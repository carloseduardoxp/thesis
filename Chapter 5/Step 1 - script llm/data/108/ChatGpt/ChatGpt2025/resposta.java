import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.conf.updater.Adam;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.lossfunctions.LossFunctions;

public class ExampleNeuralNetwork {
    public static void main(String[] args) throws Exception {
        int inputNum = 784;
        int hiddenNum = 300;
        int outputNum = 10;
        int batchSize = 64;
        int nEpochs = 10;

        // Load MNIST dataset
        MnistDataSetIterator mnistTrain = new MnistDataSetIterator(batchSize, true, 12345);

        // Define the neural network architecture
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
            .seed(12345)
            .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
            .updater(new Adam())
            .list()
            .layer(0, new DenseLayer.Builder().nIn(inputNum).nOut(hiddenNum)
                .activation("relu").build())
            .layer(1, new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                .nIn(hiddenNum).nOut(outputNum).activation("softmax").build())
            .pretrain(false).backprop(true).build();

        // Create the neural network
        MultiLayerNetwork net = new MultiLayerNetwork(conf);
        net.init();

        // Train the neural network
        for (int i = 0; i < nEpochs; i++) {
            while (mnistTrain.hasNext()) {
                DataSet ds = mnistTrain.next();
                net.fit(ds);
            }
            mnistTrain.reset();
            net.save("model-" + i + ".zip");
        }

        // Set listeners and print accuracy placeholder
        net.setListeners(new ScoreIterationListener(100));
        System.out.println("Accuracy: ");
    }
}
