public class Teste {

    public static void main(String[] args) {

        String[] strArray = {"Hello", " ", "World", "!"};
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str);
        }
        String result = sb.toString();
        System.out.println(result); // Output: Hello World!
    }
}