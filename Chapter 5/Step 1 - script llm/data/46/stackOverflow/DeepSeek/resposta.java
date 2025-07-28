class A
{
    static class C
    {
        static int x;
    }
}

public class Teste
{
    public static void main(String[] str)
    {
        A.C.x = 0; // Example usage of the static field
    }
}
