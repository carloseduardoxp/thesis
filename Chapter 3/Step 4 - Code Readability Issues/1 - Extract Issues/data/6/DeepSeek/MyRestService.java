import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api")
public class MyRestService {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, World!";
    }

    @POST
    @Path("/greet")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response greetUser(User user) {
        String greeting = "Hello, " + user.getName() + "!";
        return Response.ok().entity(new Greeting(greeting)).build();
    }
}

// Simple POJOs
class User {
    private String name;
    // getters and setters
}

class Greeting {
    private String message;
    // constructor, getters
}
