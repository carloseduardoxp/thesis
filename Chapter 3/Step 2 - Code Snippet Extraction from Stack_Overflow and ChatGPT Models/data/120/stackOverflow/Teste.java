public class Teste {

    public static void main(String[] args) {    
        String myString = "aaa";    
        String newString = myString.replaceAll("[>\\[\\],-]", "");
    }
}