public class Teste {
    public static void main(String[] args) throws Exception {
        String command = "c:\\program files\\tomcat\\bin\\startup.bat";//for linux use .sh
        Runtime.getRuntime().exec(command);
    }
}
