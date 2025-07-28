
import javax.servlet.http.HttpSession;

// ... inside your doGet() or doPost() method
public class Gemini {

    public static void main(String[] args) {

        HttpSession session = request.getSession();
// At this point, 'session' will always be a valid HttpSession object.
// It might be an existing one or a newly created one.

    }

}
