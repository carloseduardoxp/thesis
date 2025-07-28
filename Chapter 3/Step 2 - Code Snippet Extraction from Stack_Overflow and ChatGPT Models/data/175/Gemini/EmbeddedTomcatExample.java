import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class EmbeddedTomcatExample {

    public static void main(String[] args) throws LifecycleException, ServletException {
        // Set the base directory for Tomcat (important for temporary files, logs, etc.)
        // Using "temp" directory in the current working directory
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");

        // Configure the port
        tomcat.setPort(8080);

        // Add a Host (usually "localhost")
        tomcat.getHost().setAppBase("."); // Use current directory as app base

        // Create a web application context
        String contextPath = "/mywebapp"; // The context path for your application (e.g., http://localhost:8080/mywebapp)
        String docBase = new File("src/main/webapp").getAbsolutePath(); // Path to your webapp directory (where your JSPs, HTML, etc., are)

        Context context = tomcat.addWebapp(contextPath, docBase);

        // If you have compiled classes in target/classes, you need to add them as resources
        // This is crucial for servlets and other Java classes to be found by Tomcat
        File additionWebInfClasses = new File("target/classes");
        StandardRoot resources = new StandardRoot(context);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
        context.setResources(resources);

        // Add a simple servlet programmatically (for demonstration)
        Tomcat.addServlet(context, "myServlet", new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                resp.getWriter().println("Hello from Embedded Tomcat!");
            }
        });
        context.addServletMappingDecoded("/hello", "myServlet");

        // Start Tomcat
        tomcat.start();
        System.out.println("Tomcat started on port " + tomcat.getConnector().getPort());

        // Keep the server running until explicitly stopped
        tomcat.getServer().await();
    }
}
