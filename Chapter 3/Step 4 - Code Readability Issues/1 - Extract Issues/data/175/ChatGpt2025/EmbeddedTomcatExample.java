import org.apache.catalina.startup.Tomcat;

public class EmbeddedTomcatExample {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector(); // Trigger the creation of the default connector

        // Add a basic web app or context
        tomcat.addWebapp("", System.getProperty("java.io.tmpdir"));

        tomcat.start();
        tomcat.getServer().await(); // Keep running
    }
}
