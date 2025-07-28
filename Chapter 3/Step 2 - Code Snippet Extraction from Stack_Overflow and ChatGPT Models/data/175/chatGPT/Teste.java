
import java.io.File;


public class Teste {

    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();
        tomcat.addWebapp("", new File("webapp").getAbsolutePath());
        tomcat.start();
        tomcat.stop();

    }
}
