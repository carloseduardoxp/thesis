public class ColoredText {
    public static void main(String[] args) {
        // Text colors
        System.out.println("\u001B[30mBlack text");
        System.out.println("\u001B[31mRed text");
        System.out.println("\u001B[32mGreen text");
        System.out.println("\u001B[33mYellow text");
        System.out.println("\u001B[34mBlue text");
        System.out.println("\u001B[35mMagenta text");
        System.out.println("\u001B[36mCyan text");
        System.out.println("\u001B[37mWhite text");

        // Background colors
        System.out.println("\u001B[40mBlack background");
        System.out.println("\u001B[41mRed background");
        System.out.println("\u001B[42mGreen background");
        System.out.println("\u001B[43mYellow background");
        System.out.println("\u001B[44mBlue background");
        System.out.println("\u001B[45mMagenta background");
        System.out.println("\u001B[46mCyan background");
        System.out.println("\u001B[47mWhite background");

        // Text styles (bold, italic, underline)
        System.out.println("\u001B[1mBold text");
        System.out.println("\u001B[3mItalic text");
        System.out.println("\u001B[4mUnderline text");

        // Combining styles and colors
        System.out.println("\u001B[31;1mBold Red text");
        System.out.println("\u001B[34;4mUnderlined Blue text");

        // Resetting to default
        System.out.println("\u001B[0mDefault text");
    }
}
