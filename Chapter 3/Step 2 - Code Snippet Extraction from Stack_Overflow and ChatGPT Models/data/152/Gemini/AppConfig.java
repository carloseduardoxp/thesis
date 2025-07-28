import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.app.service", "com.example.app.repository", "com.example.app.controller"})
public class AppConfig {
    // Your configuration goes here
}
