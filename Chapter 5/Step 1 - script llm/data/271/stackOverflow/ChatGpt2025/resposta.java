class ClassA extends Draw {

    public ClassA() {
        super();
    }

}

public class ClassC {

    public void getParent(Object aClass) {

        String superClass = aClass.getClass().getSuperclass().getName();

    }
}