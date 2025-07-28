import org.apache.catalina.startup.Tomcat;

public class EmbeddedTomcat {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        
        // Set base directory (where Tomcat will look for conf, webapps, etc.)
        tomcat.setBaseDir("temp");
        
        // Set port
        tomcat.setPort(8080);
        
        // Add web application
        tomcat.addWebapp("/myapp", "/path/to/your/webapp");
        
        // Start the server
        tomcat.start();
        
        System.out.println("Tomcat started on port 8080");
        
        // Keep the server running
        tomcat.getServer().await();
    }
}
