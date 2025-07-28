public class Teste {

    public static void main(String[] args) {        
        int i, j, k;
        i = 0; // 0
        j = i++; // return i , then increment i
        // j = 0; i = 1;
        k = ++i; // first increment and return i
        //k = 2; i = 2;
        
        // now
        // but , using post increment would 
        // j++ == k-- == i-- // false because => 0 == 2 == 2;
        // but after that statement j will be 1, k = 1, i = 1;
    }
}