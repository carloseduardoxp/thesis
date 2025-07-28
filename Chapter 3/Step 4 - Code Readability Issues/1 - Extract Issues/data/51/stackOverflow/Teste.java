public class Teste {

    
    public static void main(String[] args) { 
        MutableList<String> list =
        Lists.mutable.with("ACD", "CDE", "DEB", "EBJ", "BJK", "JKO", 
                "ACD", "CDE", "DEX", "EXB", "XBJ", "BJK", "JKO", "KOL");
        MutableList<ObjectIntPair<String>> pairs =
                list.toBag().topOccurrences(1);
        System.out.println(pairs);
    }
    
}