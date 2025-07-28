public class Teste {

    public static void main(String[] args) { 
        DateTime dt = new DateTime("04/02/2011 20:27:05");       
        DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss").parseDateTime("04/02/2011 20:27:05");
    }
}