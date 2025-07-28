import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.Random;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    public static class User {
        public int id;
        public String name;

        public User() {} // Required for Jackson

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") int id) {
        // In a real application, you would fetch the user from a database
        return new User(id, "User " + id);
    }

    @POST
    public User createUser(User user) {
        // In a real application, you would save the user to a database
        user.id = new Random().nextInt(1000); // Assign a random ID
        return user;
    }
}
