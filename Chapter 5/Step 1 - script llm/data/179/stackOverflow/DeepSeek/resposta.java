public class Teste {

    public static void main(String[] args) throws Exception {        
        new MyObject();        
        Class.forName("subin.rnd.MyObject").newInstance();
        new MyObject();
        new ObjectInputStream(anInputStream).readObject();
    }
}
