import java.util.*;

public class Teste {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a series of items: ");
        String input = keyboard.nextLine();

        String[] original = input.split(" ");
        List<String> finalList = new ArrayList<>();

        for (String s : original) {
            if (!finalList.contains(s)) {
                finalList.add(s);
            }
        }

        System.out.println("\nHere is the set list:");
        System.out.println(finalList);
        System.out.println("\n");
    }
}
