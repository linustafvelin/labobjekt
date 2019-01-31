import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class VehicleTest {
    private Saab95 saab = new Saab95(0, 0);
    private Volvo240 volvo = new Volvo240(0, 0);

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.Test
    public void getNrDoorsVolvo() {
        assertTrue(volvo.getNrDoors() == 4);
    }

    @org.junit.Test
    public void getNrDoorsSaab() {
        assertTrue(saab.getNrDoors()==2);
    }

    @org.junit.Test
    public void getEnginePowerVolvo() {
        assertTrue(volvo.getEnginePower() == 100);
    }

    @org.junit.Test
    public void getEnginePowerSaab() {
        assertTrue(saab.getEnginePower()==125);
    }

    @org.junit.Test
    public void getCurrentSpeedSaab() {
        saab.startEngine();
        assertTrue(saab.getCurrentSpeed() == 0.1);
    }

    @org.junit.Test
    public void getCurrentSpeedVolvo() {
        volvo.startEngine();
        assertTrue(volvo.getCurrentSpeed()==0.1);
    }

    @Test
    public void getColorVolvo() {
        assertTrue(volvo.getColor() == Color.black);
    }

    @Test
    public void getColorSaab() {
        assertTrue(saab.getColor()==Color.red);
    }

    @Test
    public void setColorSaab() {
        saab.setColor(Color.yellow);
        assertTrue(saab.getColor() == Color.yellow);
    }

    @Test
    public void setColorVolvo() {
        volvo.setColor(Color.yellow);
        assertTrue(volvo.getColor()==Color.yellow);
    }

    @Test
    public void startEngineSaab() {
        saab.startEngine();
        assertTrue(saab.getCurrentSpeed() == 0.1);
    }

    @Test
    public void startEngineVolvo() {
        volvo.startEngine();
        assertTrue(volvo.getCurrentSpeed()==0.1);
    }

    @Test
    public void startEngineSaabTwice() {
        saab.startEngine();
        saab.startEngine();
        assertTrue(saab.getCurrentSpeed() == 0.1);
    }

    @Test
    public void startEngineVolvoTwice() {
        volvo.startEngine();
        volvo.startEngine();
        assertTrue(volvo.getCurrentSpeed()==0.1);
    }

    @Test
    public void stopEngineSaab() {
        saab.startEngine();
        saab.stopEngine();
        assertTrue(saab.getCurrentSpeed() == 0);
    }

    @Test
    public void stopEngineTwiceSaab() {
        saab.startEngine();
        saab.stopEngine();
        saab.stopEngine();
        assertTrue(saab.getCurrentSpeed()==0);
    }

    @Test
    public void stopEngineVolvo() {
        volvo.startEngine();
        volvo.stopEngine();
        assertTrue(volvo.getCurrentSpeed() == 0);
    }

    @Test
    public void stopEngineTwiceVolvo() {
        volvo.startEngine();
        volvo.stopEngine();
        volvo.stopEngine();
        assertTrue(volvo.getCurrentSpeed() == 0);
    }

    @Test
    public void speedFactorVolvo() {
        assertTrue(volvo.speedFactor() == 100 * 0.01 * 1.25);
    }

    @Test
    public void speedFactorSaabTurboOff() {
        saab.setTurboOff();
        assertTrue(saab.speedFactor() == saab.getEnginePower() * 0.01 * 1);
    }
    @Test
    public void speedFactorSaabTurboOn() {
        saab.setTurboOn();
        assertTrue(saab.speedFactor() == saab.getEnginePower() * 0.01 * 1.3);
    }

    @Test
    public void incrementSpeedVolvo() {
        volvo.startEngine();
        volvo.incrementSpeed(20);
        assertTrue(volvo.getCurrentSpeed() == Math.min(0.1 + volvo.speedFactor() * 20, volvo.getEnginePower()));
    }
    @Test
    public void incrementSpeedSaab() {
        saab.startEngine();
        saab.incrementSpeed(20);
        assertTrue(saab.getCurrentSpeed() == 0.1 + saab.speedFactor() * 20);

    }

    @Test
    public void decrementSpeedVolvo() {
        volvo.startEngine();
        volvo.incrementSpeed(50);
        double speedVolvo = volvo.getCurrentSpeed();
        volvo.decrementSpeed(10);
        assertTrue(volvo.getCurrentSpeed() == Math.max(speedVolvo - volvo.speedFactor() * 10, 0));
    }
    @Test
    public void decrementSpeedSaab() {
        saab.startEngine();
        saab.incrementSpeed(50);
        double speedSaab = saab.getCurrentSpeed();
        saab.decrementSpeed(10);
        assertTrue(saab.getCurrentSpeed() == speedSaab - saab.speedFactor() * 10);
    }

    @Test
    public void moveVolvo() {
        volvo.setXcoord(0);
        volvo.setYcoord(0);
        volvo.setDir(0);
        volvo.move();
        assertTrue(volvo.getycoord()==volvo.getCurrentSpeed());
    }
    @Test
    public void moveSaab(){
        saab.setXcoord(0);
        saab.setYcoord(0);
        saab.setDir(0);
        saab.move();
        assertTrue(saab.getycoord()==saab.getCurrentSpeed());
    }

    @Test
    public void turnLeftVolvo() {
        volvo.setDir(0);
        volvo.turnLeft();
        assertTrue(volvo.getDir()==3);
    }

    @Test
    public void turnRightVolvo() {
        volvo.setDir(3);
        volvo.turnRight();
        assertTrue(volvo.getDir()==0);
    }
    @Test
    public void turnLeftSaab() {
        saab.setDir(0);
        saab.turnLeft();
        assertTrue(saab.getDir()==3);
    }

    @Test
    public void turnRightSaab() {
        saab.setDir(3);
        saab.turnRight();
        assertTrue(saab.getDir()==0);
    }

    @Test
    public void gasVolvo() {
        volvo.startEngine();
        volvo.gas(0.5);
        assertTrue(volvo.getCurrentSpeed() > 0.1);
    }
    @Test
    public void gasVolvoToomuch() {
        volvo.startEngine();
        volvo.gas(3);
        assertTrue(volvo.getCurrentSpeed() == 0.1);
    }
    @Test
    public void gasVolvoNegativeValue() {
        volvo.startEngine();
        volvo.gas((-3));
        assertTrue(volvo.getCurrentSpeed() == 0.1);
    }
    @Test
    public void gasSaab() {
        saab.startEngine();
        saab.gas(0.5);
        assertTrue(saab.getCurrentSpeed() > 0.1);
    }
    @Test
    public void gasSaabToomuch() {
        saab.startEngine();
        saab.gas(3);
        assertTrue(saab.getCurrentSpeed() == 0.1);
    }
    @Test
    public void gasSaabNegativeValue() {
        saab.startEngine();
        saab.gas((-3));
        assertTrue(saab.getCurrentSpeed() == 0.1);
    }
    @Test
    public void brakeVolvo() {
        volvo.startEngine();
        volvo.incrementSpeed(20); // speed to 25.1
        volvo.brake(1);
        assertTrue(volvo.getCurrentSpeed() == 23.85);
    }
    @Test
    public void brakeVolvoTooMuch() {
        volvo.startEngine();
        volvo.incrementSpeed(20); // speed to 25.1
        volvo.brake(2);
        assertTrue(volvo.getCurrentSpeed() == 25.1);
    }
    @Test
    public void brakeVolvoAtEngineStart() {
        volvo.startEngine();
        volvo.brake(1);
        assertTrue(volvo.getCurrentSpeed() == 0);

    }
    @Test
    public void brakeSaab() {
        saab.startEngine();
        saab.incrementSpeed(20); // speed to 25.1
        saab.brake(1);
        assertTrue(saab.getCurrentSpeed() == 23.85);
    }
    @Test
    public void brakeSaabTooMuch() {
        saab.startEngine();
        saab.incrementSpeed(20); // speed to 25.1
        saab.brake(2);
        assertTrue(saab.getCurrentSpeed() == 25.1);
    }
    @Test
    public void brakeSaabAtEngineStart() {
        saab.startEngine();
        saab.brake(1);
        assertTrue(saab.getCurrentSpeed() == 0);

    }
}
