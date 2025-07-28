public class Teste {
  public static void main(String[] args) {
    int[] rgb = hexToRgb("#FFA500");
    System.out.println("Red: " + rgb[0]);
    System.out.println("Green: " + rgb[1]);
    System.out.println("Blue: " + rgb[2]);

  }

  public static int[] hexToRgb(String hex) {
    int[] rgb = new int[3];
    hex = hex.replaceAll("#", "");
    if (hex.length() == 3) {
        rgb[0] = Integer.parseInt(hex.substring(0, 1), 16) * 17;
        rgb[1] = Integer.parseInt(hex.substring(1, 2), 16) * 17;
        rgb[2] = Integer.parseInt(hex.substring(2, 3), 16) * 17;
    } else if (hex.length() == 6) {
        rgb[0] = Integer.parseInt(hex.substring(0, 2), 16);
        rgb[1] = Integer.parseInt(hex.substring(2, 4), 16);
        rgb[2] = Integer.parseInt(hex.substring(4, 6), 16);
    } else {
        throw new IllegalArgumentException("Invalid hex code");
    }
    return rgb;
  }

}
