interface A {
    public void a();
}

class AImpl implements A {
    @Override
    public void a() {
        System.out.println("Do something");
    }
}

public class Teste {

    public static void main(String[] args) {        
        A aa = new AImpl();
        aa.a();
    }
}