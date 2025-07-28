import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

public class Teste {

    @GET
    @Path("/yourservice")
    @Produces("text/xml")
    public String activate(@Context HttpServletRequest req, @Context SecurityContext context) {

        String ipAddressRequestCameFrom = req.getRemoteAddr();
        // header name is case insensitive
        String xForwardedForIP = req.getHeader("X-Forwarded-For");

        // if xForwardedForIP is populated use it, else return ipAddressRequestCameFrom 
        String ip = xForwardedForIP != null ? xForwardedForIP : ipAddressRequestCameFrom;
        System.out.println("IP is " + ip);

        // get the host name the client contacted. If the header `Host` is populated the `Host` header is automatically returned.
        // An AWS ALB populated the Host header for you.
        String hostNameRequestCameFrom = req.getServerName();
        System.out.println("Host is " + hostNameRequestCameFrom);

        //Also if security is enabled
        Principal principal = context.getUserPrincipal();

    }

}
