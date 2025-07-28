public class Teste {

    public static void main(String[] args) {      
        String s = new String("abc\u0000def");
        System.out.println(s.toCharArray());
    }
}                                                               