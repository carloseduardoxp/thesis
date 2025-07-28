

import java.util.ArrayList;

public class Gemini {

    public static void main(String[] args) {

        ArrayList<String> myArrayList = new ArrayList<>();
        myArrayList.add("Apple");
        myArrayList.add("Banana");
        myArrayList.add("Cherry");

        for (int i = 0; i < myArrayList.size(); i++) {
            String element = myArrayList.get(i);
            System.out.println(element);
        }
    }
}
