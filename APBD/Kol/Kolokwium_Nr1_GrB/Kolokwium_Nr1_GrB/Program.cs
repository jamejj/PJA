using Kolokwium_Nr1_GrB.Services;

namespace Kolokwium_Nr1_GrB;

public class Program
{
    public static void Main(string[] args)
    {
    var builder = WebApplication.CreateBuilder(args);

        builder.Services.AddAuthorization();
        
        builder.Services.AddEndpointsApiExplorer();
        builder.Services.AddSwaggerGen();
        
        
        builder.Services.AddControllers();
        builder.Services.AddScoped<IDbService, DbService>();


//        builder.Services.AddOpenApi();

        var app = builder.Build();
/*
        if (app.Environment.IsDevelopment())
        {
            app.MapOpenApi();
        }
        */
        if (app.Environment.IsDevelopment())
        {
            app.UseSwagger();
            app.UseSwaggerUI();
        }
        
        app.UseAuthorization();
        
        app.MapControllers();
        
        app.Run();
    }
}