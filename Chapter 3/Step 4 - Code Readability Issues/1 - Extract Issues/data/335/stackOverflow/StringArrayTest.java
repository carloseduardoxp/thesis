import java.util.Arrays;  
import java.util.List;  
import java.util.ArrayList;  

public class StringArrayTest {

   public static void main(String[] args) {  
      String[] words = {"ace", "boom", "crew", "dog", "eon"};  

      List<String> wordList = Arrays.asList(words);  

      for (String e : wordList) {  
         System.out.println(e);  
      }  
   }  
}