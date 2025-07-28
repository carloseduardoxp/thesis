public class Teste {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, CloneNotSupportedException, java.io.IOException {
        new MyObject();
        Class.forName("subin.rnd.MyObject").newInstance();
        MyObject anotherObject = new MyObject();
        anotherObject.clone();
        ObjectInputStream inStream = new ObjectInputStream(anInputStream);
        inStream.readObject();
    }
}
