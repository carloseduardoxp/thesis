public class GradientDescent {

  // Define the cost function
  public static double costFunction(double x, double y) {
    return Math.pow(x - 1, 2) + Math.pow(y - 2.5, 2);
  }

  // Define the gradient function
  public static double[] gradientFunction(double x, double y) {
    double[] gradient = new double[2];
    gradient[0] = 2 * (x - 1);
    gradient[1] = 2 * (y - 2.5);
    return gradient;
  }

  // Implement the gradient descent algorithm
  public static double[] gradientDescent(double initialX, double initialY, double learningRate, int numIterations) {
    double[] point = new double[2];
    point[0] = initialX;
    point[1] = initialY;
    for (int i = 0; i < numIterations; i++) {
      double[] gradient = gradientFunction(point[0], point[1]);
      point[0] -= learningRate * gradient[0];
      point[1] -= learningRate * gradient[1];
    }
    return point;
  }

  public static void main(String[] args) {
    double initialX = 0;
    double initialY = 0;
    double learningRate = 0.1;
    int numIterations = 100;
    double[] point = gradientDescent(initialX, initialY, learningRate, numIterations);
    System.out.println("Minimum point: (" + point[0] + ", " + point[1] + ")");
    System.out.println("Minimum value: " + costFunction(point[0], point[1]));
  }
}
