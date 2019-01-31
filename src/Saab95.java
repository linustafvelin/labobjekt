import java.awt.*;

public class Saab95 extends Vehicle{

    private boolean turboOn;

    /**
     * Constructor to initialize a Saab95
     * @param xcoord - gives the car a x-coordinate.
     * @param ycoord - gives the car an y-coordinate.
     */
    public Saab95(double xcoord, double ycoord){
        super(2, 125, Color.red, "Saab95", xcoord, ycoord);
        this.turboOn = false;
    }

    boolean getTurbo() {
        return turboOn;
    }

    /**
     * Turns on the turbo
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Turns of the turbo
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    /**
     * Returns the speed factor of the car which depends on the engine power and the car's turbo
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
