public class MultipleOccurrencesExample {
  public static void main(String[] args) {
     // Define the string and substring to search for
     String str = "The quick brown fox jumps over the lazy dog";
     String subStr = "o";

     // Initialize a counter variable
     int count = 0;

     // Search for the substring until it's not found
     int index = str.indexOf(subStr);
     while (index != -1) {
        count++;
        index = str.indexOf(subStr, index + 1);
     }

     // Print the result
     System.out.println("The substring \"" + subStr + "\" occurs " + count + " times.");
  }
}
