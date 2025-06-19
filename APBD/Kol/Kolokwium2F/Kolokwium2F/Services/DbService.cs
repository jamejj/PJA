using Kolokwium2F.Data;
using Kolokwium2F.DTOs;
using Kolokwium2F.Models;
using Microsoft.EntityFrameworkCore;

namespace Kolokwium2F.Services;

public class DbService : IDbService
{
    private readonly DatabaseContext _context;

    public DbService(DatabaseContext context)
    {
        _context = context;
    }

    public async Task<GalleryExhibitionDto> GetGalleryExhibitions(int galleryId)
    {
        var gallery = await _context.Galleries
            .Include(g => g.Exhibitions)
            .ThenInclude(e => e.ExhibitionArtworks)
            .ThenInclude(ea => ea.Artwork)
            .ThenInclude(a => a.Artist)
            .FirstOrDefaultAsync(g => g.GalleryId == galleryId);

        if (gallery == null) throw new Exception("Gallery not found");

        return new GalleryExhibitionDto
        {
            GalleryId = gallery.GalleryId,
            Name = gallery.Name,
            EstablishedDate = gallery.EstablishedDate,
            Exhibitions = gallery.Exhibitions.Select(e => new ExhibitionDto
            {
                Title = e.Title,
                StartDate = e.StartDate,
                EndDate = e.EndDate,
                NumberOfArtworks = e.NumberOfArtworks,
                Artworks = e.ExhibitionArtworks.Select(ea => new ArtworkDto
                {
                    Title = ea.Artwork.Title,
                    YearCreated = ea.Artwork.YearCreated,
                    InsuranceValue = ea.InsuranceValue,
                    Artist = new ArtistDto
                    {
                        FirstName = ea.Artwork.Artist.FirstName,
                        LastName = ea.Artwork.Artist.LastName,
                        BirthDate = ea.Artwork.Artist.BirthDate
                    }
                }).ToList()
            }).ToList()
        };
    }

    public async Task AddExhibitionAsync(CreateExhibitionRequest request)
    {
        var gallery = await _context.Galleries.FirstOrDefaultAsync(g => g.Name == request.Gallery);
        if (gallery == null)
            throw new Exception("Gallery not found");

        var exhibition = new Exhibition
        {
            Title = request.Title,
            GalleryId = gallery.GalleryId,
            StartDate = request.StartDate,
            EndDate = request.EndDate,
            NumberOfArtworks = request.Artworks.Count,
            ExhibitionArtworks = new List<ExhibitionArtwork>()
        };

        foreach (var item in request.Artworks)
        {
            var artwork = await _context.Artworks.FindAsync(item.ArtworkId);
            if (artwork == null)
                throw new Exception($"Artwork with ID {item.ArtworkId} not found");

            exhibition.ExhibitionArtworks.Add(new ExhibitionArtwork
            {
                ArtworkId = item.ArtworkId,
                InsuranceValue = item.InsuranceValue
            });
        }

        _context.Exhibitions.Add(exhibition);
        await _context.SaveChangesAsync();
    }
}