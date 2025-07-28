
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Teste {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("apple", "banana", "cherry", "date");
        Comparator<String> myComparator = Comparator.comparing(String::length);

        List<String> sortedList = myList.stream()
                                        .sorted(myComparator)
                                        .collect(Collectors.toList());

        System.out.println(sortedList);


    }
}
