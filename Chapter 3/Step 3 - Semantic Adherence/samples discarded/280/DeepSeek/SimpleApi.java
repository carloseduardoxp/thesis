import static spark.Spark.*;

public class SimpleApi {
    public static void main(String[] args) {
        // Set the port (default is 4567)
        port(8080);
        
        // Enable CORS
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        // Simple GET endpoint
        get("/hello", (req, res) -> "Hello World!");
        
        // GET with path parameter
        get("/hello/:name", (req, res) -> {
            return "Hello " + req.params(":name");
        });
        
        // POST endpoint
        post("/users", (req, res) -> {
            // Typically you would parse the request body here
            res.type("application/json");
            return "{\"message\": \"User created\"}";
        });
        
        // PUT endpoint
        put("/users/:id", (req, res) -> {
            res.type("application/json");
            return "{\"message\": \"User " + req.params(":id") + " updated\"}";
        });
        
        // DELETE endpoint
        delete("/users/:id", (req, res) -> {
            res.type("application/json");
            return "{\"message\": \"User " + req.params(":id") + " deleted\"}";
        });
        
        // After filter to set content type
        after((req, res) -> {
            res.type("application/json");
        });
    }
}
