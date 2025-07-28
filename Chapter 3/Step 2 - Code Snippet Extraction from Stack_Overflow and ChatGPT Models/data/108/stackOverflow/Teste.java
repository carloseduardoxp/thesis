
public class Teste {

    public static void main(String[] args) {
        BasicNetwork network = new BasicNetwork();

// add layers in the neural network
        network.addLayer(new BasicLayer(null, true, 3));
        network.addLayer(new BasicLayer(new ActivationTANH(), true, 4));
        network.addLayer(new BasicLayer(new ActivationTANH(), true, 1));

// finalize and randomize the neural network
        network.getStructure().finalizeStructure();
        network.reset();

// define a random training set.
// You can define using your double arrays here
        MLDataSet training = RandomTrainingFactory.generate(1000, 5, network.getInputCount(), network.getOutputCount(), -1, 1);

        ResilientPropagation train = new ResilientPropagation(network, training);
        double error = 0;
        Integer epochs = 0;

//starting training
        do {
            //train
            train.iteration();

            //count how many iterations the loop has
            epochs++;

            // get the error of neural network in the training set
            error = train.getError();

// condition for stop training
        } while (epochs < 1000 && error > 0.01);
    }
}
