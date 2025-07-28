public class FFT {
    public static void main(String[] args) {
        Complex[] input = {
            new Complex(1, 0), new Complex(0, 0),
            new Complex(-1, 0), new Complex(0, 0)
        };

        Complex[] output = fft(input);

        for (Complex c : output) {
            System.out.println(c);
        }
    }

    public static Complex[] fft(Complex[] x) {
        int n = x.length;

        if (n == 1) return new Complex[] { x[0] };

        if ((n & (n - 1)) != 0) {
            throw new IllegalArgumentException("Array length must be a power of 2");
        }

        Complex[] even = new Complex[n / 2];
        Complex[] odd = new Complex[n / 2];
        for (int i = 0; i < n / 2; i++) {
            even[i] = x[2 * i];
            odd[i] = x[2 * i + 1];
        }

        fft(even);
    }
}
