public class User {
  // getters and setters
}

class UserController extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     // Retrieve user data from the form
     String name = request.getParameter("name");
     String email = request.getParameter("email");
     
     // Create a new user object
     User user = new User();
     user.setName(name);
     user.setEmail(email);
     
     // Set the user object as an attribute of the request object
     request.setAttribute("user", user);
     
     // Forward the request to the view
     RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
     dispatcher.forward(request, response);
  }
}