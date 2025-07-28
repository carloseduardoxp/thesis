public class Teste {

    public static void main(String[] args) {        
        String regex = "[+]?(?:[0-9]\\s*){4,7}";

        System.out.println("0045234".matches(regex));       // true
        System.out.println("+004 5234".matches(regex));      // true
        System.out.println("+00 452 34".matches(regex));    // true
        System.out.println("0 0 4 5 2 3 4".matches(regex)); // true
        System.out.println("004523434534".matches(regex));  // false
        System.out.println("004".matches(regex));           // false
    }
}