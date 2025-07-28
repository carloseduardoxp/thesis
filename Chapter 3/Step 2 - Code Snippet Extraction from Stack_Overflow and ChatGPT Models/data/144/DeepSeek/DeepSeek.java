
public class DeepSeek {

    public static void main(String[] args) {

// Get the current session (create if doesn't exist)
        HttpSession session = request.getSession();

// Get the current session without creating a new one (returns null if no session)
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Session exists
            String sessionId = session.getId();
            long creationTime = session.getCreationTime();
            long lastAccessedTime = session.getLastAccessedTime();

            // Check if a specific attribute exists
            if (session.getAttribute("username") != null) {
                String username = (String) session.getAttribute("username");
            }
        } else {
            // No session exists
        }

    }

}
