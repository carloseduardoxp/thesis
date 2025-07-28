import java.util.ArrayList;
import java.util.List;

public class GradientDescentLinearRegression {

    // Data points
    private List<Double> x;
    private List<Double> y;

    // Model parameters
    private double m; // slope
    private double b; // y-intercept

    // Hyperparameters
    private double learningRate;
    private int numIterations;

    public GradientDescentLinearRegression(List<Double> x, List<Double> y, double learningRate, int numIterations) {
        if (x.size() != y.size()) {
            throw new IllegalArgumentException("X and Y lists must have the same size.");
        }
        this.x = x;
        this.y = y;
        this.learningRate = learningRate;
        this.numIterations = numIterations;

        // Initialize parameters randomly or to 0
        this.m = 0.0;
        this.b = 0.0;
        // Or for slightly better starting point:
        // this.m = Math.random() * 10 - 5;
        // this.b = Math.random() * 10 - 5;
    }

    // Predict Y given X
    private double predict(double xVal) {
        return m * xVal + b;
    }

    // Calculate Mean Squared Error (Loss Function)
    private double calculateMSE() {
        double mse = 0.0;
        for (int i = 0; i < x.size(); i++) {
            double predictedY = predict(x.get(i));
            mse += Math.pow(y.get(i) - predictedY, 2);
        }
        return mse / x.size();
    }

    // Perform Gradient Descent
    public void train() {
        int n = x.size();

        for (int iter = 0; iter < numIterations; iter++) {
            double gradientM = 0.0;
            double gradientB = 0.0;

            // Calculate gradients for 'm' and 'b'
            for (int i = 0; i < n; i++) {
                double predictedY = predict(x.get(i));
                double error = y.get(i) - predictedY;
                gradientM += -x.get(i) * error; // Derivative of MSE w.r.t m
                gradientB += -error;           // Derivative of MSE w.r.t b
            }

            gradientM = (2.0 / n) * gradientM;
            gradientB = (2.0 / n) * gradientB;

            // Update parameters
            m = m - learningRate * gradientM;
            b = b - learningRate * gradientB;

            // Optional: Print loss every few iterations to see progress
            if (iter % (numIterations / 10) == 0) {
                System.out.printf("Iteration %d, MSE: %.4f, m: %.4f, b: %.4f%n",
                                   iter, calculateMSE(), m, b);
            }
        }
        System.out.printf("Training complete. Final m: %.4f, Final b: %.4f, Final MSE: %.4f%n",
                          m, b, calculateMSE());
    }

    public double getM() {
        return m;
    }

    public double getB() {
        return b;
    }

    public static void main(String[] args) {
        // Sample data
        List<Double> xData = new ArrayList<>();
        List<Double> yData = new ArrayList<>();

        // Example: y = 2x + 5 (with some noise)
        for (int i = 0; i < 100; i++) {
            double xVal = i * 0.1;
            double yVal = 2 * xVal + 5 + (Math.random() - 0.5) * 2.0; // Adding some noise
            xData.add(xVal);
            yData.add(yVal);
        }

        // Initialize and train the model
        double learningRate = 0.01;
        int numIterations = 1000;
        GradientDescentLinearRegression model = new GradientDescentLinearRegression(xData, yData, learningRate, numIterations);
        model.train();

        // Test the trained model
        System.out.println("\nTesting predictions:");
        System.out.printf("For x=3.0, predicted y: %.4f (Expected around 11)%n", model.predict(3.0));
        System.out.printf("For x=7.5, predicted y: %.4f (Expected around 20)%n", model.predict(7.5));
    }
}
