

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main entry point for the Spring Boot application.
 * The @SpringBootApplication annotation is a convenience annotation that adds:
 * - @Configuration: Tags the class as a source of bean definitions for the application context.
 * - @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings,
 * other beans, and various property settings. For example, if spring-webmvc is on the classpath,
 * it configures a DispatcherServlet.
 * - @ComponentScan: Tells Spring to look for other components, configurations, and services
 * in the 'com.example.demowebservice' package, allowing it to find our controller.
 */
@SpringBootApplication
public class DemoWebServiceApplication {

    public static void main(String[] args) {
        // This static method runs the Spring Boot application.
        // It sets up the default configuration, starts the embedded web server (Tomcat by default),
        // and deploys the application.
        SpringApplication.run(DemoWebServiceApplication.class, args);
    }

}
