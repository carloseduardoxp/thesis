import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;

public class ServerCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setContextPath("/myapp");
        factory.setPort(8080);
        factory.setDisplayName("My Application");
        factory.setUriEncoding(StandardCharsets.UTF_8);
    }
}
