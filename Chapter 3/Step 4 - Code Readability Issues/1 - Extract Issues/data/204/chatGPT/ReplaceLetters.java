public class ReplaceLetters {
  public static void main(String[] args) {
      String str = "Hello World";
      String newStr = str.replace('o', 'x');
      System.out.println(newStr);  // prints "Hellx Wxrld"
      
      String anotherStr = "The quick brown fox jumps over the lazy dog";
      String newAnotherStr = anotherStr.replaceAll("[aeiou]", "-");
      System.out.println(newAnotherStr);  // prints "Th- q--ck br--wn f-x j-mps -v-r th- l-zy d-g"
  }
}
