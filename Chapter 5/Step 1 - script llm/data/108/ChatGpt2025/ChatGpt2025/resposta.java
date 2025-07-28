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
        double[] hidden = calculateLayerOutput(weightsInputHidden, hiddenBias, input, hiddenNodes, inputNodes);
        double[] output = calculateLayerOutput(weightsHiddenOutput, outputBias, hidden, outputNodes, hiddenNodes);
        return output;
    }

    private double[] calculateLayerOutput(double[][] weights, double[] bias, double[] input, int layerNodes, int prevLayerNodes) {
        double[] output = new double[layerNodes];
        for (int i = 0; i < layerNodes; i++) {
            double sum = bias[i];
            for (int j = 0; j < prevLayerNodes; j++) {
                sum += weights[i][j] * input[j];
            }
            output[i] = sigmoid(sum);
        }
        return output;
    }

    public void train(double[] input, double[] target) {
        // Forward pass
        double[] hidden = calculateLayerOutput(weightsInputHidden, hiddenBias, input, hiddenNodes, inputNodes);
        double[] output = calculateLayerOutput(weightsHiddenOutput, outputBias, hidden, outputNodes, hiddenNodes);

        // Output error
        double[] outputErrors = new double[outputNodes];
        for (int i = 0; i < outputNodes; i++) {
            outputErrors[i] = target[i] - output[i];
        }

        // Hidden -> Output weights update
        updateWeightsAndBias(weightsHiddenOutput, outputBias, output, outputErrors, hidden, outputNodes, hiddenNodes);

        // Hidden layer error
        double[] hiddenErrors = calculateHiddenErrors(weightsHiddenOutput, outputErrors, hiddenNodes, outputNodes);

        // Input -> Hidden weights update
        updateWeightsAndBias(weightsInputHidden, hiddenBias, hidden, hiddenErrors, input, hiddenNodes, inputNodes);
    }

    private void updateWeightsAndBias(
            double[][] weights, double[] bias, double[] layerOutput, double[] errors, double[] prevLayerOutput,
            int layerNodes, int prevLayerNodes) {
        for (int i = 0; i < layerNodes; i++) {
            double gradient = dsigmoid(layerOutput[i]) * errors[i] * learningRate;
            for (int j = 0; j < prevLayerNodes; j++) {
                weights[i][j] += gradient * prevLayerOutput[j];
            }
            bias[i] += gradient;
        }
    }

    private double[] calculateHiddenErrors(
            double[][] nextLayerWeights, double[] nextLayerErrors, int currentLayerNodes, int nextLayerNodes) {
        double[] errors = new double[currentLayerNodes];
        for (int i = 0; i < currentLayerNodes; i++) {
            double error = 0;
            for (int j = 0; j < nextLayerNodes; j++) {
                error += nextLayerWeights[j][i] * nextLayerErrors[j];
            }
            errors[i] = error;
        }
        return errors;
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
