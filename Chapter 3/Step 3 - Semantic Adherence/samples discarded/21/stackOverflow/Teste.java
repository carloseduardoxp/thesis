import java.util.Scanner;

class newClass {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String temp = s.next();
            if(temp.trim().equals("quit"))
                System.exit(0);
            System.out.println(s.next());
        }
        s.close();
    }
}