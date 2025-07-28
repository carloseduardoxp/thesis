public class Teste {

    
    public static void main(String[] args) {
        String g = "line";
        //string to char
        char c = g.charAt(0);
        char[] c_arr = g.toCharArray();
        //char to string
        char[] charArray = {'a', 'b', 'c'};
        String str = String.valueOf(charArray);
        //(or iterate the charArray and append each character to str -> str+=charArray[i])
    }
    
}