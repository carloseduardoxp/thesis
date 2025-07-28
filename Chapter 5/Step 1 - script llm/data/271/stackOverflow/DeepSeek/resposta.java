class ClassA extends Draw {

    public ClassA() {
        super();
    }
} 

public class ClassC {

    public getParent(Object aClass) {
        String superClass = aClass.getClass().getSuperclass().getName();
    }
}
