using Kolokwium2C_Poprawa.DTOs;

namespace Kolokwium2C_Poprawa.Services;

public interface IDbService
{
    Task<RacerDto> GetRacerParticipationAsync(int id);
    Task AddParticipantsToTrackRaceAsync(TrackRaceParticipantsRequest dto);
}