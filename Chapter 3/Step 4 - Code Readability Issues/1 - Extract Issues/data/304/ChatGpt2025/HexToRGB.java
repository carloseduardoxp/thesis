public class HexToRGB {
    public static void main(String[] args) {
        String hexColor = "#1A2B3C"; // example hex color

        // Remove '#' if present
        if (hexColor.startsWith("#")) {
            hexColor = hexColor.substring(1);
        }

        // Parse the hex string into an integer
        int colorInt = Integer.parseInt(hexColor, 16);

        // Extract the RGB components
        int red = (colorInt >> 16) & 0xFF;
        int green = (colorInt >> 8) & 0xFF;
        int blue = colorInt & 0xFF;

        System.out.println("Red: " + red);
        System.out.println("Green: " + green);
        System.out.println("Blue: " + blue);
    }
}
