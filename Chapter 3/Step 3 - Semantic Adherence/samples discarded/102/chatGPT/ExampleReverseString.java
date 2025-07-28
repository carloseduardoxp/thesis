public class ExampleReverseString {
    public static void main(String[] args) {
      String str = "Hello, world!";
      
      // Convert the string to a character array
      char[] charArray = str.toCharArray();
      
      // Reverse the character array
      int i = 0;
      int j = charArray.length - 1;
      while (i < j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        i++;
        j--;
      }
      
      // Convert the character array back to a string
      String reversedStr = new String(charArray);
      
      // Display the reversed string
      System.out.println("Reversed string: " + reversedStr);
    }
  }
  