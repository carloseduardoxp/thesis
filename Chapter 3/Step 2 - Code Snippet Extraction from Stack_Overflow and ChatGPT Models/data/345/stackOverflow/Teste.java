public class Teste {

    public static void main(String[] args) {        
        String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

        System.out.println("line 1" + newLine + "line2");
    }
}