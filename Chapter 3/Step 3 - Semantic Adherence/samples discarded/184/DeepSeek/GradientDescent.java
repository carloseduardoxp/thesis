public class GradientDescent {
    
    // Training data
    private static final double[][] X = {{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}};
    private static final double[] y = {2, 4, 5, 4, 5};
    
    // Parameters
    private static final double learningRate = 0.01;
    private static final int iterations = 1000;
    
    public static void main(String[] args) {
        // Initial parameters (theta0 and theta1)
        double[] theta = {0, 0};
        
        System.out.println("Initial parameters: theta0 = " + theta[0] + ", theta1 = " + theta[1]);
        
        // Perform gradient descent
        theta = gradientDescent(X, y, theta, learningRate, iterations);
        
        System.out.println("Final parameters: theta0 = " + theta[0] + ", theta1 = " + theta[1]);
        
        // Make a prediction
        double prediction = predict(theta, new double[]{1, 6});
        System.out.println("Prediction for x=6: " + prediction);
    }
    
    public static double[] gradientDescent(double[][] X, double[] y, double[] theta, 
                                         double learningRate, int iterations) {
        int m = y.length; // number of training examples
        double[] tempTheta = new double[theta.length];
        
        for (int iter = 0; iter < iterations; iter++) {
            // Compute predictions
            double[] predictions = new double[m];
            for (int i = 0; i < m; i++) {
                predictions[i] = predict(theta, X[i]);
            }
            
            // Compute errors
            double[] errors = new double[m];
            for (int i = 0; i < m; i++) {
                errors[i] = predictions[i] - y[i];
            }
            
            // Compute gradient for each parameter
            for (int j = 0; j < theta.length; j++) {
                double gradient = 0;
                for (int i = 0; i < m; i++) {
                    gradient += errors[i] * X[i][j];
                }
                tempTheta[j] = theta[j] - (learningRate * gradient / m);
            }
            
            // Update parameters simultaneously
            System.arraycopy(tempTheta, 0, theta, 0, theta.length);
        }
        
        return theta;
    }
    
    public static double predict(double[] theta, double[] x) {
        double prediction = 0;
        for (int j = 0; j < theta.length; j++) {
            prediction += theta[j] * x[j];
        }
        return prediction;
    }
}
