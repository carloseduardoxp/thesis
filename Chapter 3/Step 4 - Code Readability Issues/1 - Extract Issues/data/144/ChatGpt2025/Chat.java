
public class Chat {

    public static void main(String[] args) {

        HttpSession session = request.getSession(false);
        if (session == null) {
            // No session exists
            System.out.println("No session found.");
        } else {
            // Session exists
            System.out.println("Session found with ID: " + session.getId());
        }

    }

}
