import java.util.HashMap;

public class DictionaryExample {
    public static void main(String[] args) {
        // create a HashMap to store the dictionary
        HashMap<String, String> dictionary = new HashMap<>();
        
        // add some entries to the dictionary
        dictionary.put("apple", "a fruit that is red or green");
        dictionary.put("book", "a written or printed work consisting of pages glued or sewn together along one side");
        dictionary.put("computer", "an electronic device that can store, retrieve, and process data");
        
        // retrieve the definition of a word
        String definition = dictionary.get("book");
        System.out.println(definition); // Output: a written or printed work consisting of pages glued or sewn together along one side
    }
}
