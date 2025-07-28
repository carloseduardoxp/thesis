public class Test {

    public static void main(String[] args) {
        int[][] myArray = new int[3][7];

        // Print first dimension
        System.out.println(myArray.length);   // prints 3

        myArray = addRow(myArray);

        // Print first dimension
        System.out.println(myArray.length);   // prints 4

    }

    private static int[][] addRow(int[][] previous) {

        int prevRowCount = previous.length;

        int[][] withExtraRow = new int[prevRowCount + 1][];
        System.arraycopy(previous, 0, withExtraRow, 0, previous.length);
        withExtraRow[prevRowCount] = new int[] { 1, 2, 3, 4, 5, 6, 7 };

        return withExtraRow;
    }

}

