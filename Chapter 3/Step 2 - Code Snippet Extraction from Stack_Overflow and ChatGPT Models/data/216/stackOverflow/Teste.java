
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teste {

    public static void main(String[] args) {        
        String s = "To: John Smith <john@smith.com>, Janes Smith\n"
        + "<jane@smith.org>, Tom Barter <tom@test.co.uk>, Other \n"
        + "Weird @#$@<>#^Names <other@names.me>, \n"
        + "Long Long Long Long Name <longlong@name.com>";
        s = s.substring(3); // filter TO:
        System.out.println(s);
        // Use DOTALL pattern  
        Pattern p = Pattern.compile("(.*?)<([^>]+)>\\s*,?",Pattern.DOTALL);

        Matcher m = p.matcher(s);

        while(m.find()) {
            // filter newline
            String name = m.group(1).replaceAll("[\\n\\r]+", ""); 
            String email = m.group(2).replaceAll("[\\n\\r]+", "");
            System.out.println(name + " -> " + email);
        }
    }
}