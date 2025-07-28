
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Teste {

    public static void main(String[] args) {        
        FileOutputStream fos = new FileOutputStream("example.kmz");
        ZipOutputStream zoS = new ZipOutputStream(fos);
        ZipEntry ze = new ZipEntry("doc.kml");
        zoS.putNextEntry(ze);
        PrintStream ps = new PrintStream(zoS);
        ps.println("<?xml version='1.0' encoding='UTF-8'?>");
        ps.println("<kml xmlns='http://www.opengis.net/kml/2.2'>");
        // write out contents of KML file ...
        ps.println("<Document>");
        ps.println("<Placemark>");
        // ...
        ps.println("</Placemark>");
        ps.println("</Document>");
        ps.println("</kml>");
        ps.flush();
        zoS.closeEntry(); // close KML entry
        // include and write other files (E.g. icons, overlays, other KML files, etc.)
        zoS.close();
    }
}