public class Teste {

    public static void main(String[] args) {        
        String s = "How are you";
        int cutPos = s.length()/2;
        String s1 = s.substring(0, cutPos);
        String s2 = s.substring(cutPos, s.length()); //which is essentially the same as
        //String s2 = s.substring(cutPos);
    }
}