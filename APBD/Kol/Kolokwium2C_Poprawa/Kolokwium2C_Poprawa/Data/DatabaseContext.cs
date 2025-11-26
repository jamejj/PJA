using Kolokwium2C_Poprawa.Models;
using Microsoft.EntityFrameworkCore;

namespace Kolokwium2C_Poprawa.Data;

public class DatabaseContext : DbContext
{
    public DbSet<Racer> Racers => Set<Racer>();
    public DbSet<Race> Races => Set<Race>();
    public DbSet<Track> Tracks => Set<Track>();
    public DbSet<TrackRace> TrackRaces => Set<TrackRace>();
    public DbSet<RaceParticipation> RaceParticipations => Set<RaceParticipation>();

    public DatabaseContext(DbContextOptions options) : base(options) {}

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
      
        modelBuilder.Entity<TrackRace>().HasKey(tr => new { tr.RaceId, tr.TrackId });
        modelBuilder.Entity<RaceParticipation>().HasKey(rp => new { rp.RaceId, rp.TrackId, rp.RacerId });

        modelBuilder.Entity<RaceParticipation>()
            .HasOne(rp => rp.Race)
            .WithMany()
            .HasForeignKey(rp => rp.RaceId);

          modelBuilder.Entity<RaceParticipation>()
            .HasOne(rp => rp.Track)
            .WithMany()
            .HasForeignKey(rp => rp.TrackId);

        modelBuilder.Entity<Racer>().HasData(
            new Racer { RacerId = 1, FirstName = "Lewis", LastName = "Hamilton" },
            new Racer { RacerId = 2, FirstName = "Max", LastName = "Verstappen" }
        );

        modelBuilder.Entity<Track>().HasData(
            new Track { TrackId = 1, Name = "Silverstone Circuit", LengthInKm = 5.89m },
            new Track { TrackId = 2, Name = "Monaco Circuit", LengthInKm = 3.34m }
        );

        modelBuilder.Entity<Race>().HasData(
            new Race { RaceId = 1, Name = "British Grand Prix", Location = "Silverstone, UK", Date = new DateTime(2025, 7, 14) },
            new Race { RaceId = 2, Name = "Monaco Grand Prix", Location = "Monte Carlo, Monaco", Date = new DateTime(2025, 5, 25) }
        );

        modelBuilder.Entity<TrackRace>().HasData(
            new TrackRace { TrackId = 1, RaceId = 1, Laps = 52, BestTimeInSeconds = 5460 },
            new TrackRace { TrackId = 2, RaceId = 2, Laps = 78, BestTimeInSeconds = 6300 }
        );

        modelBuilder.Entity<RaceParticipation>().HasData(
            new RaceParticipation { RacerId = 1, RaceId = 1, TrackId = 1, FinishTimeInSeconds = 5460, Position = 1 },
            new RaceParticipation { RacerId = 2, RaceId = 2, TrackId = 2, FinishTimeInSeconds = 6300, Position = 2 }
        );
    }
}