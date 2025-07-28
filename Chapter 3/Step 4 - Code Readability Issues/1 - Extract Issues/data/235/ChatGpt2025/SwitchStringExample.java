public class SwitchStringExample {
    public static void main(String[] args) {
        String fruta = "maçã";

        switch (fruta) {
            case "maçã":
                System.out.println("É uma maçã.");
                break;
            case "banana":
                System.out.println("É uma banana.");
                break;
            case "laranja":
                System.out.println("É uma laranja.");
                break;
            default:
                System.out.println("Fruta desconhecida.");
                break;
        }
    }
}
