import java.awt.*;

public abstract class Vehicle implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    String modelName; // The car model name
    private double xcoord;
    private double ycoord;
    private int dir = 0;

    /**
     * Constructor for class Vehicle that is used for subclasses
     * Volvo240 and Saab95
     * @param nrDoors - Number of doors the car have
     * @param enginePower - Power of engine the car have
     * @param color - Color of the car
     * @param modelName - The model name of the car
     * @param xcoord - The car's x-coordinate
     * @param ycoord - The car's y-coordinate
     */
    public Vehicle(int nrDoors, double enginePower,
                  Color color, String modelName,
                   double xcoord, double ycoord) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        stopEngine();
    }

    /**
     * Return the number of the doors the car has
     * @return - number of doors
     */
    public int getNrDoors(){
        return nrDoors;
    }

    public double getXcoord() {
        return xcoord;
    }
    public void setXcoord(double xcoord) {
        this.xcoord = xcoord;
    }
    public double getycoord() {
        return ycoord;
    }
    public void setYcoord(double xycoord) {
        this.ycoord = ycoord;
    }
    public void setDir(int dir) {
        this.dir = dir;
    }
    public int getDir() {
        return dir;
    }

    /**
     * Reads and returns the engine power of the car
     * @return - Returns engine power of the car
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Read and return the current speed of the car
     * @return
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Read and returns the color of the car
     * @return - Color of the car
     */
    public Color getColor(){
        return color;
    }

    /**
     * Set a color for the car
     * @param clr - Gives the car a possible new color
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Gives a value to currentSpeed
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Stops the car(currentSpeed is set to 0)
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Returns the speedFactor of the car, which depends on
     * the car's equipment, enginepower etc - see override method in subclasses
     * @return the speed factor
     */
    public abstract double speedFactor();

    /**
     * Increments the speed of the car
     * @param amount - How much you want to increase the current speed of the car
     */
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    /**
     * Decreases the speed of the car
     * @param amount How much you want to decrease the current speed of the car
     */
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * Moves the car in a direction(0 - North, 1 - East, 2 - South, 3 - West)
     * Moves it with the current speed in a given direction(0, 1, 2, 3)
     */
    public void move() {
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    ycoord = ycoord + currentSpeed;
                    break;
                case 1:
                    xcoord = xcoord + currentSpeed;
                    break;
                case 2:
                    ycoord = ycoord - currentSpeed;
                    break;
                case 3:
                    xcoord = xcoord - currentSpeed;
                    break;
            }
        }
    }

    /**
     * Turns the car left. Starting from north(1), west(3), south(2), east(1)
     */
    public void turnLeft() {
        /*
        0 = North
        1 = East
        2 = South
        3 = West
                */
        if(dir <= 0) {
            dir = 3;
        } else {
            dir = dir - 1;
        }
    }

    /**
     * Turns the car right. Starting from north(0), east(1), south(2), west(3)
     */
    public void turnRight() {
        if (dir >= 3) {
            dir = 0;
        } else {
            dir = dir + 1;
        }
    }


    /**
     * Incereases the current speed of the car
     * @param amount - How much to increase the speed, accepts value's [0,1]
     */
    public void gas(double amount){
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }

    }

    /**
     * Decreases the current speed of the car
     * @param amount - How much to decrease the speed, accepts value's [0,1]
     */
    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {


            decrementSpeed(amount);
        }

    }

}
