package container;

public class Neuron {
    // attributes
    private static double minWeightValue ; // shared amongst all neurons -> set in general method
    private static double maxWeightValue ; // shared amongst all neurons -> set in general method
    private double[] weights ; // array of double
    private double gradient ;
    private double bias ;
    private double value ;

    // constructors
    public Neuron(double[] weights , double bias) {
        // set value with setter methods
        setWeights( weights );
        setGradient(0); // gradient = 0
        setBias(bias);
        setValue(0); // value = 0
    }
    public Neuron(double value) {
        // set value with setter methods
        setWeights( null );
        setGradient(-1);
        setBias(-1);
        setValue(value);
    }

    // getter - setter methods
    public static double getMaxWeightValue() {
        return maxWeightValue;
    }

    public static void setMaxWeightValue(double maxWeightValue) {
        Neuron.maxWeightValue = maxWeightValue;
    }

    public double[] getWeights() {
        return weights;
    }

    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    public static double getMinWeightValue() {
        return minWeightValue;
    }

    public static void setMinWeightValue(double minWeightValue) {
        Neuron.minWeightValue = minWeightValue;
    }

    public double getGradient() {
        return gradient;
    }

    public void setGradient(double gradient) {
        this.gradient = gradient;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    // another methods
    public static void setRangeWeight(double min, double max) {
        setMinWeightValue(min);
        setMaxWeightValue(max);
    }


}
