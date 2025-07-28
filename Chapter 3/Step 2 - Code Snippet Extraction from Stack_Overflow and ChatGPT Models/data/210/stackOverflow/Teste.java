
import java.io.OutputStream;

public class Teste {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"userDirectory.csv\"");
        try {
            OutputStream outputStream = response.getOutputStream();
            String outputResult = "xxxx, yyyy, zzzz, aaaa, bbbb, ccccc, dddd, eeee, ffff, gggg\n";
            outputStream.write(outputResult.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
