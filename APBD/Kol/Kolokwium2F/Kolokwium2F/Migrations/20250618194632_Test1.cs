using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Kolokwium2F.Migrations
{
    /// <inheritdoc />
    public partial class Test1 : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Artists",
                columns: table => new
                {
                    ArtistId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    FirstName = table.Column<string>(type: "nvarchar(100)", maxLength: 100, nullable: false),
                    LastName = table.Column<string>(type: "nvarchar(100)", maxLength: 100, nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Artists", x => x.ArtistId);
                });

            migrationBuilder.CreateTable(
                name: "Galleries",
                columns: table => new
                {
                    GalleryId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Name = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: false),
                    EstablishedDate = table.Column<DateTime>(type: "datetime2", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Galleries", x => x.GalleryId);
                });

            migrationBuilder.CreateTable(
                name: "Artworks",
                columns: table => new
                {
                    ArtworkId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    ArtistId = table.Column<int>(type: "int", nullable: false),
                    Title = table.Column<string>(type: "nvarchar(100)", maxLength: 100, nullable: false),
                    YearCreated = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Artworks", x => x.ArtworkId);
                    table.ForeignKey(
                        name: "FK_Artworks_Artists_ArtistId",
                        column: x => x.ArtistId,
                        principalTable: "Artists",
                        principalColumn: "ArtistId",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "Exhibitions",
                columns: table => new
                {
                    ExhibitionId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    GalleryId = table.Column<int>(type: "int", nullable: false),
                    Title = table.Column<string>(type: "nvarchar(100)", maxLength: 100, nullable: false),
                    StartDate = table.Column<DateTime>(type: "datetime2", nullable: false),
                    EndDate = table.Column<DateTime>(type: "datetime2", nullable: false),
                    NumberOfArtworks = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Exhibitions", x => x.ExhibitionId);
                    table.ForeignKey(
                        name: "FK_Exhibitions_Galleries_GalleryId",
                        column: x => x.GalleryId,
                        principalTable: "Galleries",
                        principalColumn: "GalleryId",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "Exhibition_Artwork",
                columns: table => new
                {
                    Exhibition = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    ArtworkId = table.Column<int>(type: "int", nullable: false),
                    InsuranceValue = table.Column<decimal>(type: "decimal(18,2)", nullable: false),
                    ExhibitionId = table.Column<int>(type: "int", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Exhibition_Artwork", x => x.Exhibition);
                    table.ForeignKey(
                        name: "FK_Exhibition_Artwork_Artworks_ArtworkId",
                        column: x => x.ArtworkId,
                        principalTable: "Artworks",
                        principalColumn: "ArtworkId",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Exhibition_Artwork_Exhibitions_ExhibitionId",
                        column: x => x.ExhibitionId,
                        principalTable: "Exhibitions",
                        principalColumn: "ExhibitionId");
                });

            migrationBuilder.CreateIndex(
                name: "IX_Artworks_ArtistId",
                table: "Artworks",
                column: "ArtistId");

            migrationBuilder.CreateIndex(
                name: "IX_Exhibition_Artwork_ArtworkId",
                table: "Exhibition_Artwork",
                column: "ArtworkId");

            migrationBuilder.CreateIndex(
                name: "IX_Exhibition_Artwork_ExhibitionId",
                table: "Exhibition_Artwork",
                column: "ExhibitionId");

            migrationBuilder.CreateIndex(
                name: "IX_Exhibitions_GalleryId",
                table: "Exhibitions",
                column: "GalleryId");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Exhibition_Artwork");

            migrationBuilder.DropTable(
                name: "Artworks");

            migrationBuilder.DropTable(
                name: "Exhibitions");

            migrationBuilder.DropTable(
                name: "Artists");

            migrationBuilder.DropTable(
                name: "Galleries");
        }
    }
}
