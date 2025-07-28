public class Teste {
  public static void main(String[] args) {
    String color = "red";

    switch (color) {
        case "red":
            System.out.println("The color is red");
            break;
        case "blue":
            System.out.println("The color is blue");
            break;
        case "green":
            System.out.println("The color is green");
            break;
        default:
            System.out.println("The color is unknown");
            break;
    }

  }
}
