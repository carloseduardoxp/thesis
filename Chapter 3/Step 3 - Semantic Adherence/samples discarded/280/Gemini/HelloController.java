

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This annotation marks the class as a REST controller
@RequestMapping("/api") // Base path for all endpoints in this controller
public class HelloController {

    // This method handles GET requests to /api/hello
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from your simple API!";
    }

    // This method handles GET requests to /api/greeting
    @GetMapping("/greeting")
    public String getGreeting() {
        return "Greetings, developer!";
    }
}
