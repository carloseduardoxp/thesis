using System;

class Program
{
    static void Main()
    {
        Console.WriteLine("Program running...");
        
        // Exit with success code (like Java's System.exit(0))
        Environment.Exit(0);
        
        // This line won't execute
        Console.WriteLine("This won't print");
    }
}
