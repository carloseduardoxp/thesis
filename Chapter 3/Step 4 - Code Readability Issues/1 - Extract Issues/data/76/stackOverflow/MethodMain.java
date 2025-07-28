class Test {

    static private Test t = null;
    static {
        t = new Test();
    }

    private Test(){}

    public static Test getT() {
        return t;
    }

    public String helloMethod() {
        return "Singleton Design Pattern";
    }
}


public class MethodMain {

    public static void main(String[] args) {
        Test t = Test.getT();
        System.out.println(t.helloMethod());
    }
}