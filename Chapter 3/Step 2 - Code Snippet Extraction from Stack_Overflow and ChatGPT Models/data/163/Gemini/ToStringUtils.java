public class ToStringUtils {
    public static void main(String[] args) {
        // From primitive types
        int num = 123;
        String strNum = String.valueOf(num);
        System.out.println("int to String: " + strNum); // Output: 123

        double dbl = 45.67;
        String strDbl = String.valueOf(dbl);
        System.out.println("double to String: " + strDbl); // Output: 45.67

        boolean bool = true;
        String strBool = String.valueOf(bool);
        System.out.println("boolean to String: " + strBool); // Output: true

        char ch = 'A';
        String strChar = String.valueOf(ch);
        System.out.println("char to String: " + strChar); // Output: A

        // From objects (calls the object's toString() method)
        Object obj = new Object();
        String strObj = String.valueOf(obj);
        System.out.println("Object to String: " + strObj); // Output: (e.g., java.lang.Object@15db9742)

        Integer integerObj = Integer.valueOf(789);
        String strIntegerObj = String.valueOf(integerObj);
        System.out.println("Integer object to String: " + strIntegerObj); // Output: 789
    }
}
