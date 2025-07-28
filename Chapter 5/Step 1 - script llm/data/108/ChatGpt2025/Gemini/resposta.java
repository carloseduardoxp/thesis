import java.util.Random;

public class NeuralNetwork {
    int inputNodes;
    int hiddenNodes;
    int outputNodes;
    double[][] weightsInputHidden;
    double[][] weightsHiddenOutput;
    double[] hiddenBias;
    double[] outputBias;
    double learningRate = 0.1;

    Random rand = new Random();

    public NeuralNetwork(int inputNodes, int hiddenNodes, int outputNodes) {
        this.inputNodes = inputNodes;
        this.hiddenNodes = hiddenNodes;
        this.outputNodes = outputNodes;

        weightsInputHidden = new double[hiddenNodes][inputNodes];
        weightsHiddenOutput = new double[outputNodes][hiddenNodes];
        hiddenBias = new double[hiddenNodes];
        outputBias = new double[outputNodes];

        initWeights(weightsInputHidden);
        initWeights(weightsHiddenOutput);
        initBias(hiddenBias);
        initBias(outputBias);
    }

    private void initWeights(double[][] weights) {
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[i].length; j++) {
                weights[i][j] = rand.nextDouble() * 2 - 1; // values between -1 and 1
            }
        }
    }

    private void initBias(double[] bias) {
        for (int i = 0; i < bias.length; i++) {
            bias[i] = rand.nextDouble() * 2 - 1;
        }
    }

    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    private double dsigmoid(double y) {
        return y * (1 - y); // derivative of sigmoid
    }

    public double[] feedforward(double[] input) {
        double[][] activations = performForwardPass(input);
        return activations[1]; // Return only the output layer's activations
    }

    public void train(double[] input, double[] target) {
        // Forward pass to get activations for both layers
        double[][] activations = performForwardPass(input);
        double[] hidden = activations[0];
        double[] output = activations[1];

        // Backpropagate errors and update weights
        backpropagate(input, target, hidden, output);
    }

    private double[][] performForwardPass(double[] input) {
        // Hidden layer
        double[] hidden = new double[hiddenNodes];
        for (int i = 0; i < hiddenNodes; i++) {
            double sum = hiddenBias[i];
            for (int j = 0; j < inputNodes; j++) {
                sum += weightsInputHidden[i][j] * input[j];
            }
            hidden[i] = sigmoid(sum);
        }

        // Output layer
        double[] output = new double[outputNodes];
        for (int i = 0; i < outputNodes; i++) {
            double sum = outputBias[i];
            for (int j = 0; j < hiddenNodes; j++) {
                sum += weightsHiddenOutput[i][j] * hidden[j];
            }
            output[i] = sigmoid(sum);
        }
        return new double[][]{hidden, output};
    }

    private void backpropagate(double[] input, double[] target, double[] hidden, double[] output) {
        // Calculate output layer errors
        double[] outputErrors = new double[outputNodes];
        for (int i = 0; i < outputNodes; i++) {
            outputErrors[i] = target[i] - output[i];
        }

        // Calculate hidden layer errors (by backpropagating output errors)
        double[] hiddenErrors = new double[hiddenNodes];
        for (int i = 0; i < hiddenNodes; i++) {
            double error = 0;
            for (int j = 0; j < outputNodes; j++) {
                error += weightsHiddenOutput[j][i] * outputErrors[j];
            }
            hiddenErrors[i] = error;
        }

        // Update weights and biases for the hidden -> output layer
        updateLayerWeights(weightsHiddenOutput, outputBias, outputErrors, output, hidden);

        // Update weights and biases for the input -> hidden layer
        updateLayerWeights(weightsInputHidden, hiddenBias, hiddenErrors, hidden, input);
    }

    private void updateLayerWeights(double[][] weights, double[] bias, double[] errors, double[] layerOutput, double[] prevLayerOutput) {
        for (int i = 0; i < weights.length; i++) {
            double gradient = dsigmoid(layerOutput[i]) * errors[i] * learningRate;
            for (int j = 0; j < weights[i].length; j++) {
                weights[i][j] += gradient * prevLayerOutput[j];
            }
            bias[i] += gradient;
        }
    }

    // Example usage
    public static void main(String[] args) {
        NeuralNetwork nn = new NeuralNetwork(2, 4, 1);

        // XOR training data
        double[][] inputs = {
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 1}
        };
        double[][] targets = {
            {0},
            {1},
            {1},
            {0}
        };

        // Train
        for (int i = 0; i < 10000; i++) {
            int idx = i % 4;
            nn.train(inputs[idx], targets[idx]);
        }

        // Test
        for (double[] input : inputs) {
            double[] output = nn.feedforward(input);
            System.out.printf("Input: %s -> Output: %.4f%n", java.util.Arrays.toString(input), output[0]);
        }
    }
}
