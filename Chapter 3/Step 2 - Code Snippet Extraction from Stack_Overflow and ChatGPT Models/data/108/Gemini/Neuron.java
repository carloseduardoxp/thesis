import java.util.function.Function;

public class Neuron {
    private double[] weights;
    private double bias;
    private Function<Double, Double> activationFunction; // e.g., sigmoid, relu

    public Neuron(int numInputs, Function<Double, Double> activationFunction) {
        this.weights = new double[numInputs];
        // Initialize weights randomly (small values, e.g., between -1 and 1)
        for (int i = 0; i < numInputs; i++) {
            this.weights[i] = Math.random() * 2 - 1; // Random value between -1 and 1
        }
        this.bias = Math.random() * 2 - 1; // Random bias
        this.activationFunction = activationFunction;
    }

    public double calculateOutput(double[] inputs) {
        double weightedSum = bias;
        for (int i = 0; i < weights.length; i++) {
            weightedSum += weights[i] * inputs[i];
        }
        return activationFunction.apply(weightedSum);
    }

    // Getters and Setters for weights and bias (needed for backpropagation)
    public double[] getWeights() {
        return weights;
    }

    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }
}
