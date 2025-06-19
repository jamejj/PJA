using Kolokwium2C.DTOs;

namespace Kolokwium2C.Services;

public interface IDbService
{
    Task<RacerDto> GetRacerParticipationAsync(int id);
    Task AddParticipantsToTrackRaceAsync(TrackRaceParticipantsRequest dto);
}