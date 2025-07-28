import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @CrossOrigin(origins = "http://localhost:8080") // Replace with your frontend origin
    @GetMapping("/api/data")
    public String getData() {
        return "Hello from Java!";
    }
}
