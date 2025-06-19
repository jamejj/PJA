using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

#pragma warning disable CA1814 // Prefer jagged arrays over multidimensional

namespace Kolokwium2Poprawa.Migrations
{
    /// <inheritdoc />
    public partial class TestDBCon : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.InsertData(
                table: "Backpacks",
                columns: new[] { "CharacterId", "ItemId", "Amount" },
                values: new object[,]
                {
                    { 1, 1, 2 },
                    { 1, 2, 1 },
                    { 1, 3, 1 }
                });

            migrationBuilder.InsertData(
                table: "Character_Title",
                columns: new[] { "CharacterId", "TitleId", "AcquiredAt" },
                values: new object[,]
                {
                    { 1, 1, new DateTime(2024, 6, 10, 0, 0, 0, 0, DateTimeKind.Unspecified) },
                    { 1, 2, new DateTime(2024, 6, 9, 0, 0, 0, 0, DateTimeKind.Unspecified) },
                    { 1, 3, new DateTime(2024, 6, 8, 0, 0, 0, 0, DateTimeKind.Unspecified) }
                });

            migrationBuilder.UpdateData(
                table: "Items",
                keyColumn: "ItemId",
                keyValue: 1,
                columns: new[] { "Name", "Weight" },
                values: new object[] { "Item1", 10 });

            migrationBuilder.UpdateData(
                table: "Items",
                keyColumn: "ItemId",
                keyValue: 2,
                columns: new[] { "Name", "Weight" },
                values: new object[] { "Item2", 11 });

            migrationBuilder.UpdateData(
                table: "Items",
                keyColumn: "ItemId",
                keyValue: 3,
                columns: new[] { "Name", "Weight" },
                values: new object[] { "Item3", 12 });

            migrationBuilder.UpdateData(
                table: "Titles",
                keyColumn: "TitleId",
                keyValue: 1,
                column: "Name",
                value: "Title1");

            migrationBuilder.UpdateData(
                table: "Titles",
                keyColumn: "TitleId",
                keyValue: 2,
                column: "Name",
                value: "Title2");

            migrationBuilder.UpdateData(
                table: "Titles",
                keyColumn: "TitleId",
                keyValue: 3,
                column: "Name",
                value: "Title3");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DeleteData(
                table: "Backpacks",
                keyColumns: new[] { "CharacterId", "ItemId" },
                keyValues: new object[] { 1, 1 });

            migrationBuilder.DeleteData(
                table: "Backpacks",
                keyColumns: new[] { "CharacterId", "ItemId" },
                keyValues: new object[] { 1, 2 });

            migrationBuilder.DeleteData(
                table: "Backpacks",
                keyColumns: new[] { "CharacterId", "ItemId" },
                keyValues: new object[] { 1, 3 });

            migrationBuilder.DeleteData(
                table: "Character_Title",
                keyColumns: new[] { "CharacterId", "TitleId" },
                keyValues: new object[] { 1, 1 });

            migrationBuilder.DeleteData(
                table: "Character_Title",
                keyColumns: new[] { "CharacterId", "TitleId" },
                keyValues: new object[] { 1, 2 });

            migrationBuilder.DeleteData(
                table: "Character_Title",
                keyColumns: new[] { "CharacterId", "TitleId" },
                keyValues: new object[] { 1, 3 });

            migrationBuilder.UpdateData(
                table: "Items",
                keyColumn: "ItemId",
                keyValue: 1,
                columns: new[] { "Name", "Weight" },
                values: new object[] { "Health Potion", 1 });

            migrationBuilder.UpdateData(
                table: "Items",
                keyColumn: "ItemId",
                keyValue: 2,
                columns: new[] { "Name", "Weight" },
                values: new object[] { "Sword", 10 });

            migrationBuilder.UpdateData(
                table: "Items",
                keyColumn: "ItemId",
                keyValue: 3,
                columns: new[] { "Name", "Weight" },
                values: new object[] { "Shield", 8 });

            migrationBuilder.UpdateData(
                table: "Titles",
                keyColumn: "TitleId",
                keyValue: 1,
                column: "Name",
                value: "Novice");

            migrationBuilder.UpdateData(
                table: "Titles",
                keyColumn: "TitleId",
                keyValue: 2,
                column: "Name",
                value: "Warrior");

            migrationBuilder.UpdateData(
                table: "Titles",
                keyColumn: "TitleId",
                keyValue: 3,
                column: "Name",
                value: "Legend");
        }
    }
}
