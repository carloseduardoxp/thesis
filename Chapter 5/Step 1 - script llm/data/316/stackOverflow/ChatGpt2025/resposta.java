public class SwapNumbers {

    public static void main(String[] args) {

        int[] numTens = {1, 2, 3, 4, 5}; // First array of numbers
        int[] numHundred = {100, 200, 300, 400, 500}; // Second Array of Numbers

        for (int i = 0; i < numTens.length; i++) {
            numTens[i] = numTens[i] + numHundred[i];      // statement 1
            numHundred[i] = numTens[i] - numHundred[i];   // statement 2
            numTens[i] = numTens[i] - numHundred[i];      // statement 3
        }

        System.out.println(numTens[3]); // I want my numTens displays numHundred
        System.out.println(numHundred[4]); // I want my numHundred displays numTens
    }
}