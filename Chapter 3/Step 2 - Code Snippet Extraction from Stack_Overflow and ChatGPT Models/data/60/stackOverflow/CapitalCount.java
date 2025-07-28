
import java.util.Scanner;

public class CapitalCount {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(CapitalCount.class.getResourceAsStream("test.txt"));
        int upperCaseCount = 0;
        int linecount = 0;
        String lineInput = null;
       
        while (sc.hasNextLine()) {
         lineInput = sc.nextLine();
         linecount = lineInput .length();
         for(int i=0; i < linecount; i++)
             if (Character.isUpperCase(lineInput.charAt(i))) upperCaseCount++;
        }
        System.out.println(upperCaseCount + "");
    }
    
}