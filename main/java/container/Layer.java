package container;

import function.Function;
import util.Activation;
import util.GenRandom;

public class Layer {
    // attributes
    private Neuron[] neurons ; // array of Neuron
    private Function function ;

    // constructors
    public Layer(int inNeurons , int nNeurons , Function function) {
        // Create a new layer. Set the value of the function field according to the given parameter.
        setFunction(function); ;

        // Set neurons as a new array with length equal to nNeurons.
        neurons = new Neuron[nNeurons] ; // array of Neuron class

        // For each neuron in neurons, prepare a weights array with the length equal to the value of “inNeurons”.
            // meaning : each Neuron must have weights array
        for (int pos = 0 ; pos < neurons.length ; pos++) { // length = inNeurons
            // create weights (double array) for each Neuron
            double[] weights = new double[inNeurons] ; // data type = double array

            // set value with GenRandom , for each data in weights array
            for (int i = 0 ; i < weights.length ; i++) {
                weights[i] = GenRandom.randomDouble( Neuron.getMinWeightValue() , Neuron.getMaxWeightValue() );
            }

            // random on bias then create neuron object
            double bias = GenRandom.randomDouble( 0 , 1 ) ;
            neurons[pos] = new Neuron(weights , bias);
        }
    }

    public Layer(double[] input) { // input = array of neurons
        // Initializes the neurons array with the length equal to input’s length.
        neurons = new Neuron[input.length] ;

        // Then, initialize each neuron in the array with the value from the same position in the input.
            // just a loop in array , then replace each index with neurons value
        for (int i = 0 ; i < input.length ; i++) {
            neurons[i] = new Neuron(input[i]) ;
        }

        // Finally, set the “function” variable to null.
        setFunction(null);
    }

    // getter - setter methods
    public Neuron[] getNeurons() {
        return neurons;
    }
    public void setNeurons(Neuron[] neurons) {
        this.neurons = neurons;
    }
    public Function getFunction() {
        return function;
    }
    public void setFunction(Function function) {
        this.function = function;
    }

    // general methods
    public double applyActivation(double x) {
        // check if legal using switch case
        if (function == null) {
            throw new IllegalArgumentException("Unknown activation function: " + function);
        }

        switch (function) {
            case SIGMOID :
                return Activation.sigmoid(x) ;
            case TANH :
                return Activation.tanh(x);
            case RELU :
                return Activation.relu(x) ;
            default : // otherwise of 3 types , return illegal exception
                throw new IllegalArgumentException("Unknown activation function: " + function) ;
        }
    }
    public double applyActivationDerivative(double x) {
        // check if legal using switch case
        if (function == null) {
            throw new IllegalArgumentException("Unknown activation function: " + function);
        }

        switch (function) {
            case SIGMOID :
                return Activation.sigmoidDerivative(x) ;
            case TANH :
                return Activation.tanhDerivative(x);
            case RELU :
                return Activation.reluDerivative(x) ;
            default : // otherwise of 3 types , return illegal exception
                throw new IllegalArgumentException("Unknown activation function: " + function) ;
        }
    }

}
