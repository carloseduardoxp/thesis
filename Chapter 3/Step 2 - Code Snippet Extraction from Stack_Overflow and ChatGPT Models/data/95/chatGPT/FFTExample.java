import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.*;

public class FFTExample {
    public static void main(String[] args) {
        // Define the input array of complex numbers
        Complex[] input = {
                new Complex(1, 0),
                new Complex(2, 0),
                new Complex(3, 0),
                new Complex(4, 0)
        };

        // Create a transformer to perform the FFT
        FastFourierTransformer transformer = new FastFourierTransformer(DftNormalization.STANDARD);

        // Calculate the FFT of the input array
        Complex[] output = transformer.transform(input, TransformType.FORWARD);

        // Print the results
        System.out.println("Input:");
        for (Complex c : input) {
            System.out.println(c);
        }

        System.out.println("Output:");
        for (Complex c : output) {
            System.out.println(c);
        }
    }
}
