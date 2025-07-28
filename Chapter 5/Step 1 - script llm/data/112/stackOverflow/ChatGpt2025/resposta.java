public class Teste {

    public static void main(String[] args) {      
        String s = "abc\u0000def";
        System.out.println(s.toCharArray());
    }
}