
public class Teste {

    public static void main(String[] args) {
        String command = "killall <your_proccess>";
        Process p = Runtime.getRuntime().exec(command);
        p.destroy();
    }
}
