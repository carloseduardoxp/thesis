public class NeuralNetwork {
    private int inputNodes;
    private int hiddenNodes;
    private int outputNodes;
    
    private double[][] weightsInputHidden;
    private double[][] weightsHiddenOutput;
    
    private double[] hiddenBias;
    private double[] outputBias;
    
    public NeuralNetwork(int inputNodes, int hiddenNodes, int outputNodes, double learningRate) {
        this.inputNodes = inputNodes;
        this.hiddenNodes = hiddenNodes;
        this.outputNodes = outputNodes;
        
        // Initialize weights with random values
        this.weightsInputHidden = new double[inputNodes][hiddenNodes];
        this.weightsHiddenOutput = new double[hiddenNodes][outputNodes];
        
        this.hiddenBias = new double[hiddenNodes];
        this.outputBias = new double[outputNodes];
        
        randomizeWeights();
    }
    
    private void randomizeWeights() {
        Random random = new Random();
        
        // Initialize weights between input and hidden layer
        for (int i = 0; i < inputNodes; i++) {
            for (int j = 0; j < hiddenNodes; j++) {
                weightsInputHidden[i][j] = random.nextGaussian();
            }
        }
        
        // Initialize weights between hidden and output layer
        for (int i = 0; i < hiddenNodes; i++) {
            for (int j = 0; j < outputNodes; j++) {
                weightsHiddenOutput[i][j] = random.nextGaussian();
            }
        }
        
        // Initialize biases
        for (int i = 0; i < hiddenNodes; i++) {
            hiddenBias[i] = random.nextGaussian();
        }
        
        for (int i = 0; i < outputNodes; i++) {
            outputBias[i] = random.nextGaussian();
        }
    }
}
