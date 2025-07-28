import java.lang.reflect.*;
import java.util.*;

public class Test {

    public static void main(String[] args) throws Exception {
        Method method = Test.class.getMethod("getList");
        Type returnType = method.getGenericReturnType();
        System.out.println(returnType); // java.util.List<java.lang.Integer>
        ParameterizedType parameterized = (ParameterizedType) returnType;
        System.out.println(parameterized.getActualTypeArguments()[0]);
    }    

    public List<Integer> getList() {
        return null;
    }
}