public class User {
}

class UserController extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     // Create a new user object
     User user = new User();
     
     // Set the user object as an attribute of the request object
     request.setAttribute("user", user);
     
     // Forward the request to the view
     RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
     dispatcher.forward(request, response);
  }
}
