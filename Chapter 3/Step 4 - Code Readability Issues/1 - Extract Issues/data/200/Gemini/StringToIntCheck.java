public class StringToIntCheck {

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("'123' is an integer: " + isInteger("123"));      // true
        System.out.println("'-45' is an integer: " + isInteger("-45"));     // true
        System.out.println("'0' is an integer: " + isInteger("0"));        // true
        System.out.println("'abc' is an integer: " + isInteger("abc"));     // false
        System.out.println("'123.45' is an integer: " + isInteger("123.45")); // false
        System.out.println("'' (empty string) is an integer: " + isInteger(""));          // false
        System.out.println("null is an integer: " + isInteger(null));       // false
        System.out.println("' 123 ' is an integer: " + isInteger(" 123 ")); // false (parseInt does not trim by default)
    }
}
