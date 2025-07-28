import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


class User {
    private String name;
    private int age;

    public User() { }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class UserDao {

    public User getUser() {
        // Simulate fetching a user from DB
        return new User("Alice", 25);
    }
}


@WebServlet("/user")
public class UserController extends HttpServlet {

    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userDao.getUser();
        req.setAttribute("user", user);
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }
}

