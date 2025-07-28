import org.jtransforms.fft.DoubleFFT_1D;

public class JTransformsFFTExample {
    public static void main(String[] args) {
        // Input data (must be a power of 2 for optimal performance with radix-2 FFT)
        double[] realPart = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};
        // JTransforms requires an array twice the size of the input for real data,
        // where the imaginary parts are initially zeros.
        // The output will store real and imaginary parts interleaved.
        double[] fftData = new double[realPart.length * 2];

        // Copy real data to the even indices of fftData
        for (int i = 0; i < realPart.length; i++) {
            fftData[2 * i] = realPart[i];
            fftData[2 * i + 1] = 0.0; // Initialize imaginary part to 0
        }

        DoubleFFT_1D fft = new DoubleFFT_1D(realPart.length);

        // Perform forward FFT
        fft.complexForward(fftData);

        // Output the transformed data (real and imaginary parts interleaved)
        System.out.println("FFT Result (Real + Imaginary i):");
        for (int i = 0; i < fftData.length / 2; i++) {
            System.out.printf("%.4f + %.4fi%n", fftData[2 * i], fftData[2 * i + 1]);
        }

        // Perform inverse FFT
        fft.complexInverse(fftData, true); // true for scaling the output by 1/N

        System.out.println("\nInverse FFT Result (Original Real Part):");
        for (int i = 0; i < fftData.length / 2; i++) {
            System.out.printf("%.4f%n", fftData[2 * i]);
        }
    }
}
