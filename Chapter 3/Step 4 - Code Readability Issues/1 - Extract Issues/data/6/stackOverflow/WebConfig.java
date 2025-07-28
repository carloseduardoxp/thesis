
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import javax.ws.rs.core.Response.Status; 

@ApplicationPath("/service/rest")
public class WebConfig extends Application {
}

@Path("resource/{id}")
class ApiController {

    /**
     * Call: <code>/service/rest/resource/23</code>
     *
     * @return HTTP Response
     */
    @GET
    public Response getResource(@PathParam("id") String anId) {
        Resource myResource = whatever.get(anId);
        return Response.status(Status.OK).entity(myResource).build();
    }

    @GET
    @Produces("application/json")
    public Response getResource(@PathParam("id") String anId) {
        // the same
    }

}
