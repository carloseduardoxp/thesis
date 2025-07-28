@Path("/example")
public class ExampleResource {

    @Context
    private HttpServletRequest request;

    @GET
    public Response example() {
        String clientIpAddress = request.getRemoteAddr();
        return Response.ok("Client IP Address: " + clientIpAddress).build();
    }
}
