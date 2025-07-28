import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Teste {
  public static void main(String[] args) {
    HttpServletRequest request; // obtain the request object

    HttpSession session = request.getSession(false); // pass false to getSession to avoid creating a new session

    if (session != null && session.getAttribute("userId") != null) {
        // Session exists and user is logged in
    } else {
        // Session doesn't exist or user is not logged in
    }
  }
}
