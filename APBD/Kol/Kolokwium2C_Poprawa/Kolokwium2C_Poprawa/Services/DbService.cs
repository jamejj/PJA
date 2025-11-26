using Kolokwium2C_Poprawa.Data;
using Kolokwium2C_Poprawa.DTOs;
using Kolokwium2C_Poprawa.Exceptions;
using Kolokwium2C_Poprawa.Models;
using Microsoft.EntityFrameworkCore;

namespace Kolokwium2C_Poprawa.Services;

public class DbService : IDbService
{
    private readonly DatabaseContext _context;

    public DbService(DatabaseContext context)
    {
        _context = context;
    }

    public async Task<RacerDto> GetRacerParticipationAsync(int id)
    {
        var racer = await _context.Racers
            .Include(r => r.Participations)
            .ThenInclude(p => p.Race)
            .Include(r => r.Participations)
            .ThenInclude(p => p.Track)
            .FirstOrDefaultAsync(r => r.RacerId == id);

        if (racer == null)
            throw new NotFoundException("Racer not found");

        var participationRaceIds = racer.Participations.Select(p => p.RaceId).Distinct();
        var participationTrackIds = racer.Participations.Select(p => p.TrackId).Distinct();

        var trackRaces = await _context.TrackRaces
            .Where(tr => participationRaceIds.Contains(tr.RaceId) && 
                         participationTrackIds.Contains(tr.TrackId))
            .ToListAsync();

        var dto = new RacerDto
        {
            RacerId = racer.RacerId,
            FirstName = racer.FirstName,
            LastName = racer.LastName,
            Participations = racer.Participations.Select(p => 
            {
                var trackRace = trackRaces.FirstOrDefault(tr => 
                    tr.RaceId == p.RaceId && tr.TrackId == p.TrackId);
                
                return new RacerParticipationDto
                {
                    RaceName = p.Race.Name,
                    TrackName = p.Track.Name,
                    Laps = trackRace?.Laps ?? 0,
                    BestTimeInSeconds = trackRace?.BestTimeInSeconds ?? 0,
                    FinishTimeInSeconds = p.FinishTimeInSeconds,
                    Position = p.Position
                };
            }).ToList()
        };

        return dto;
    }

public async Task AddParticipantsToTrackRaceAsync(TrackRaceParticipantsRequest dto)
{ 
    
    var race = await _context.Races
        .FirstOrDefaultAsync(r => r.Name == dto.RaceName);
    if (race == null)
        throw new BadRequestException("Race not found");


    var track = await _context.Tracks
        .FirstOrDefaultAsync(t => t.Name == dto.TrackName);
    if (track == null)
        throw new BadRequestException("Track not found");


    var trackRace = await _context.TrackRaces
        .FirstOrDefaultAsync(tr => tr.RaceId == race.RaceId && tr.TrackId == track.TrackId);

    if (trackRace == null)
    {
        trackRace = new TrackRace
        {
            RaceId = race.RaceId,
            TrackId = track.TrackId,
            Laps = 0,
            BestTimeInSeconds = int.MaxValue
        };
        _context.TrackRaces.Add(trackRace);
    }

    foreach (var participant in dto.Participations)
    {
        var racerExists = await _context.Racers.AnyAsync(r => r.RacerId == participant.RacerId);
        if (!racerExists)
            throw new BadRequestException("Racernot found");

        var alreadyParticipating = await _context.RaceParticipations
            .AnyAsync(rp => rp.RacerId == participant.RacerId && 
                           rp.RaceId == race.RaceId && 
                           rp.TrackId == track.TrackId);
        if (alreadyParticipating)
            throw new BadRequestException("Raceralready registered");

        _context.RaceParticipations.Add(new RaceParticipation
        {
            RacerId = participant.RacerId,
            RaceId = race.RaceId,
            TrackId = track.TrackId,
            FinishTimeInSeconds = participant.FinishTimeInSeconds,
            Position = participant.Position
        });

        if (participant.FinishTimeInSeconds < trackRace.BestTimeInSeconds)
        {
            trackRace.BestTimeInSeconds = participant.FinishTimeInSeconds;
        }
    }

    await _context.SaveChangesAsync();
    }
}