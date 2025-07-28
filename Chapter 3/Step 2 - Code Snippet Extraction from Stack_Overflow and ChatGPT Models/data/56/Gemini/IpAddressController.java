import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IpAddressController {

    @GetMapping("/get-ip")
    public String getClientIp(HttpServletRequest request) {
        String clientIpAddress = request.getRemoteAddr();
        return "Client IP Address: " + clientIpAddress;
    }
}
