public class Teste {
  public static void main(String[] args) {
    int num = 2;
    switch (num) {
        case 1:
        case 2:
            System.out.println("The number is either 1 or 2");
            break;
        case 3:
            System.out.println("The number is 3");
            break;
        default:
            System.out.println("The number is not 1, 2, or 3");
            break;
    }

  }
}
