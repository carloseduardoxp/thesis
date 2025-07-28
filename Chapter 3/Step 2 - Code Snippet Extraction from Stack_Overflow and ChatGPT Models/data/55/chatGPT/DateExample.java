
public class DateExample {
    public static void main(String[] args) {
        String str1 = "Hello World!";
        String str2 = "World";
        String result = str1.substring(0, str1.indexOf(str2)) + str1.substring(str1.indexOf(str2) + str2.length());
        System.out.println(result); // prints "Hello !"

        str1 = str1.replace(str2, "");
        System.out.println(str1); // prints "Hello !"


    }
}
