import java.io.FileInputStream;
import java.util.*;
import org.apache.commons.math3.transform.*;

public class FFTExample {

    public static void main(String[] args) {

        WaveDecoder decoder = new WaveDecoder(new FileInputStream(wavFile));
        FFT fft = new FFT(1024, wavFileObj.getSampleRate());

        float[] samples = new float[1024];
        float[] spectrum = new float[1024 / 2 + 1];
        float[] lastSpectrum = new float[1024 / 2 + 1];
        List<Float> spectralFlux = new ArrayList<>();

        while (decoder.readSamples(samples) > 0) {
            fft.forward(samples);
            System.arraycopy(spectrum, 0, lastSpectrum, 0, spectrum.length);
            System.arraycopy(fft.getSpectrum(), 0, spectrum, 0, spectrum.length);

            float flux = 0;
            for (int i = 0; i < spectrum.length; i++) {
                flux += (spectrum[i] - lastSpectrum[i]);
            }
            spectralFlux.add(flux);
        }
    }
}