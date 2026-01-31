package container;

public class NeuronDemo {
    // attribute
    private Neuron n ; // call Neuron class

    // no constructor

    // getter - setter methods
    public Neuron getN() {
        return n;
    }
    public void setN(Neuron n) {
        this.n = n ;
    }

    // another methods
    public void demonstrate() {

        // define neuron constructor (protect null case)
        double[] w = {0.2, 0.3, 0.4};
        this.n = new Neuron(w, 0.2);

        // set another value
        Neuron.setMinWeightValue(0.1);
        Neuron.setMaxWeightValue(0.7);
        n.setGradient(0.6);
        n.setValue( 1 );
    }
}
