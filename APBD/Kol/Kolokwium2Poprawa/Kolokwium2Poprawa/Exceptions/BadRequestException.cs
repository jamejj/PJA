namespace Kolokwium2Poprawa.Exceptions;

public class BadRequestException : Exception
{
    public BadRequestException(string message) : base(message) {}
}