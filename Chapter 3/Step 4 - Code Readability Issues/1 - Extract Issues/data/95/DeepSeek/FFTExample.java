import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.*;

public class FFTExample {

    public static Complex[] calculateFFT(double[] input) {
        // Length must be a power of 2
        int n = input.length;
        if (!isPowerOfTwo(n)) {
            throw new IllegalArgumentException("Input length must be a power of 2");
        }

        FastFourierTransformer fft = new FastFourierTransformer(DftNormalization.STANDARD);
        return fft.transform(input, TransformType.FORWARD);
    }

    private static boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        // Example usage
        double[] input = {1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0};
        
        Complex[] fftResult = calculateFFT(input);
        
        System.out.println("FFT Result:");
        for (Complex c : fftResult) {
            System.out.println(c);
        }
    }
}
