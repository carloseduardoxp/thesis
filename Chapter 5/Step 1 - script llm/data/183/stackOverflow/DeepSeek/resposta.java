public class Teste {

    public static void main(String[] args)  {
        char lastChar = new Teste().lastChar("test string");
    }   

    public char lastChar(String a) {
        return a.charAt(a.length() - 1);
    }
}
