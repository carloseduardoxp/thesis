
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListSortExample {

    public static void main(String[] args) {
        /*
* Create a collections of colours
         */
        List colours = new ArrayList();
        colours.add("red");
        colours.add("green");
        colours.add("blue");
        colours.add("yellow");
        colours.add("cyan");
        colours.add("white");
        colours.add("black");

        /*
* We can sort items of a list using the Collections.sort() method.
* We can also reverse the order of the sorting by passing the
* Collections.reverseOrder() comparator.
         */
        Collections.sort(colours);
        System.out.println(Arrays.toString(colours.toArray()));

        Collections.sort(colours, Collections.reverseOrder());
        System.out.println(Arrays.toString(colours.toArray()));

    }
