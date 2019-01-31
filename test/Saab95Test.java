import org.junit.Test;

import static org.junit.Assert.*;

public class Saab95Test {
    private Saab95 saab = new Saab95(0,0);
    @Test
    public void setTurboOn() {
        saab.setTurboOn();
        assertTrue(saab.getTurbo() == true);
    }

    @Test
    public void setTurboOff() {
        saab.setTurboOff();
        assertTrue(saab.getTurbo() == false);
    }

    @Test
    public void speedFactor() {
        assertTrue(saab.speedFactor() == 1.25);
    }

    @Test
    public void incrementSpeed() {
        saab.startEngine();
        saab.incrementSpeed(2);
        assertTrue(saab.getCurrentSpeed() == 2.6);
    }
    @Test
    public void incrementSpeedTooMuch() {
        saab.startEngine();
        saab.setTurboOn();
        saab.incrementSpeed(150);
        assertTrue(saab.getCurrentSpeed() == 125);
    }

    @Test
    public void decrementSpeed() {
        saab.startEngine();
        saab.incrementSpeed(2);
        saab.decrementSpeed(0.5);
        assertTrue(saab.getCurrentSpeed() == 1.975);
    }
    @Test
    public void decrementSpeedAtEngineStart() {
        saab.startEngine();
        saab.decrementSpeed(20);
        assertTrue(saab.getCurrentSpeed() == 0);
    }
}