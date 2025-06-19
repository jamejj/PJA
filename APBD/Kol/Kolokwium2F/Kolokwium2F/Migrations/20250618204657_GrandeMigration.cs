using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

#pragma warning disable CA1814 // Prefer jagged arrays over multidimensional

namespace Kolokwium2F.Migrations
{
    /// <inheritdoc />
    public partial class GrandeMigration : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Exhibition_Artwork_Exhibitions_ExhibitionId",
                table: "Exhibition_Artwork");

            migrationBuilder.DropPrimaryKey(
                name: "PK_Exhibition_Artwork",
                table: "Exhibition_Artwork");

            migrationBuilder.DropIndex(
                name: "IX_Exhibition_Artwork_ExhibitionId",
                table: "Exhibition_Artwork");

            migrationBuilder.DropColumn(
                name: "Exhibition",
                table: "Exhibition_Artwork");

            migrationBuilder.AlterColumn<int>(
                name: "ExhibitionId",
                table: "Exhibition_Artwork",
                type: "int",
                nullable: false,
                defaultValue: 0,
                oldClrType: typeof(int),
                oldType: "int",
                oldNullable: true);

            migrationBuilder.AddColumn<DateTime>(
                name: "BirthDate",
                table: "Artists",
                type: "datetime2",
                nullable: false,
                defaultValue: new DateTime(1, 1, 1, 0, 0, 0, 0, DateTimeKind.Unspecified));

            migrationBuilder.AddPrimaryKey(
                name: "PK_Exhibition_Artwork",
                table: "Exhibition_Artwork",
                columns: new[] { "ExhibitionId", "ArtworkId" });

            migrationBuilder.InsertData(
                table: "Artists",
                columns: new[] { "ArtistId", "BirthDate", "FirstName", "LastName" },
                values: new object[,]
                {
                    { 1, new DateTime(1881, 10, 25, 0, 0, 0, 0, DateTimeKind.Unspecified), "Pablo", "Picasso" },
                    { 2, new DateTime(1907, 7, 6, 0, 0, 0, 0, DateTimeKind.Unspecified), "Frida", "Kahlo" }
                });

            migrationBuilder.InsertData(
                table: "Galleries",
                columns: new[] { "GalleryId", "EstablishedDate", "Name" },
                values: new object[] { 1, new DateTime(2001, 9, 12, 0, 0, 0, 0, DateTimeKind.Unspecified), "Modern Art Space" });

            migrationBuilder.InsertData(
                table: "Artworks",
                columns: new[] { "ArtworkId", "ArtistId", "Title", "YearCreated" },
                values: new object[,]
                {
                    { 1, 1, "Guernica", 1937 },
                    { 2, 2, "The Two Fridas", 1939 }
                });

            migrationBuilder.InsertData(
                table: "Exhibitions",
                columns: new[] { "ExhibitionId", "EndDate", "GalleryId", "NumberOfArtworks", "StartDate", "Title" },
                values: new object[] { 1, new DateTime(2024, 9, 1, 0, 0, 0, 0, DateTimeKind.Unspecified), 1, 2, new DateTime(2024, 5, 1, 0, 0, 0, 0, DateTimeKind.Unspecified), "20th Century Giants" });

            migrationBuilder.InsertData(
                table: "Exhibition_Artwork",
                columns: new[] { "ArtworkId", "ExhibitionId", "InsuranceValue" },
                values: new object[,]
                {
                    { 1, 1, 1000000m },
                    { 2, 1, 800000m }
                });

            migrationBuilder.AddForeignKey(
                name: "FK_Exhibition_Artwork_Exhibitions_ExhibitionId",
                table: "Exhibition_Artwork",
                column: "ExhibitionId",
                principalTable: "Exhibitions",
                principalColumn: "ExhibitionId",
                onDelete: ReferentialAction.Cascade);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Exhibition_Artwork_Exhibitions_ExhibitionId",
                table: "Exhibition_Artwork");

            migrationBuilder.DropPrimaryKey(
                name: "PK_Exhibition_Artwork",
                table: "Exhibition_Artwork");

            migrationBuilder.DeleteData(
                table: "Exhibition_Artwork",
                keyColumns: new[] { "ArtworkId", "ExhibitionId" },
                keyValues: new object[] { 1, 1 });

            migrationBuilder.DeleteData(
                table: "Exhibition_Artwork",
                keyColumns: new[] { "ArtworkId", "ExhibitionId" },
                keyValues: new object[] { 2, 1 });

            migrationBuilder.DeleteData(
                table: "Artworks",
                keyColumn: "ArtworkId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Artworks",
                keyColumn: "ArtworkId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "Exhibitions",
                keyColumn: "ExhibitionId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Artists",
                keyColumn: "ArtistId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Artists",
                keyColumn: "ArtistId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "Galleries",
                keyColumn: "GalleryId",
                keyValue: 1);

            migrationBuilder.DropColumn(
                name: "BirthDate",
                table: "Artists");

            migrationBuilder.AlterColumn<int>(
                name: "ExhibitionId",
                table: "Exhibition_Artwork",
                type: "int",
                nullable: true,
                oldClrType: typeof(int),
                oldType: "int");

            migrationBuilder.AddColumn<int>(
                name: "Exhibition",
                table: "Exhibition_Artwork",
                type: "int",
                nullable: false,
                defaultValue: 0)
                .Annotation("SqlServer:Identity", "1, 1");

            migrationBuilder.AddPrimaryKey(
                name: "PK_Exhibition_Artwork",
                table: "Exhibition_Artwork",
                column: "Exhibition");

            migrationBuilder.CreateIndex(
                name: "IX_Exhibition_Artwork_ExhibitionId",
                table: "Exhibition_Artwork",
                column: "ExhibitionId");

            migrationBuilder.AddForeignKey(
                name: "FK_Exhibition_Artwork_Exhibitions_ExhibitionId",
                table: "Exhibition_Artwork",
                column: "ExhibitionId",
                principalTable: "Exhibitions",
                principalColumn: "ExhibitionId");
        }
    }
}
