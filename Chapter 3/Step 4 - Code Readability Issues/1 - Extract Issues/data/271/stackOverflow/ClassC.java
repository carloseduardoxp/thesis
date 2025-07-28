class ClassA  extends Draw{

    public ClassA(){
        super();
    }

} 

public class ClassC {

    public getParent(Object a_class)
    {

        String superClass = a_class.getClass().getSuperclass().getName();

    }
}