public class DeepSeek {

    public static void main(String[] args) {
        // Get the current session without creating a new one (returns null if no session)
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Session exists
            session.getId();
            session.getCreationTime();
            session.getLastAccessedTime();

            // Check if a specific attribute exists
            if (session.getAttribute("username") != null) {
                session.getAttribute("username");
            }
        } else {
            // No session exists
        }
    }
}
