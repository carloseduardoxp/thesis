public class Teste {

    public static void main(String[] args) {        
        MyObject object = new MyObject();        
        MyObject object1 = (MyObject) Class.forName("subin.rnd.MyObject").newInstance();
        MyObject anotherObject = new MyObject();
        MyObject object2 = (MyObject) anotherObject.clone();
        ObjectInputStream inStream = new ObjectInputStream(anInputStream );
        MyObject object3 = (MyObject) inStream.readObject();
    }
}