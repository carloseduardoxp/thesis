public class StringSplitExample {
  public static void main(String[] args) {
      String str = "The quick brown fox jumps over the lazy dog";
      String[] words = str.split(" "); // split the string into an array of words
      
      // print the words in the array
      for (String word : words) {
          System.out.println(word);
      }
  }
}
