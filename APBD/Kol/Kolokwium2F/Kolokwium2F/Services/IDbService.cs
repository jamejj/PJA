using Kolokwium2F.DTOs;

namespace Kolokwium2F.Services;

public interface IDbService
{
    Task<GalleryExhibitionDto> GetGalleryExhibitions(int galleryId);
    Task AddExhibitionAsync(CreateExhibitionRequest request);
}
