
public class Teste {

    public static void main(String[] args) {
        String command = "c:\\program files\\tomcat\\bin\\startup.bat";//for linux use .sh
        Process child = Runtime.getRuntime().exec(command);

    }
}
