public class DeepSeek {

    public static void main(String[] args) {

        // Get the current session without creating a new one (returns null if no session)
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Session exists
            // You can use session methods here if needed
            if (session.getAttribute("username") != null) {
                // Username attribute exists
            }
        } else {
            // No session exists
        }

    }

}