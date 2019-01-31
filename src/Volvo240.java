import java.awt.*;

public class Volvo240 extends Vehicle{

    private final static double trimFactor = 1.25;

    /**
     * Uses the superconstructor to give values to the different attributes and initialize a car object.
     * @param xcoord - sets the cars x-coordinate
     * @param ycoord - sets the cars y-coordinate
     */
    public Volvo240(double xcoord, double ycoord){
        super(4, 100, Color.black, "Volvo240", xcoord, ycoord);
    }

    @Override
    /**
     * Returns the speedfactor of the cars which depends on the power of the engine and the trim of the car
     */
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
