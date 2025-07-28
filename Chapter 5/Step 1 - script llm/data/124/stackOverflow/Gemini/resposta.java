public class Teste {

    public static void main(String[] args) {        
        String date1 = "07/01/2017";
        if (date1.matches("^(\\d{1,2}/){2}\\d{2,4}$")) {
            System.out.println("Date in MM/dd/yyyy format");
        } else if (date1.matches("^\\d{2,4}(-\\d{1,2}){2}\\s\\d{1,2}(:\\d{1,2}){2}\\.\\d+$")) {
            System.out.println("Date in yyyy-MM-dd hh:mm:ss.t format");
        } else {
            System.err.println("Unsupported Date format.");
        }
    }
}
