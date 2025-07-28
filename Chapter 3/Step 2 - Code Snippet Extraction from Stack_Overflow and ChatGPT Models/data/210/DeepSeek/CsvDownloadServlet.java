@WebServlet("/download")
public class CsvDownloadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set content type and headers
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"data.csv\"");
        
        // Create CSV data
        String csvData = "Name,Email,Phone\nJohn Doe,john@example.com,1234567890\nJane Smith,jane@example.com,0987654321";
        
        // Write CSV to response
        try (PrintWriter writer = response.getWriter()) {
            writer.write(csvData);
        }
    }
}
