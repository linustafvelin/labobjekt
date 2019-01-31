import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Volvo240Test {
    private Volvo240 volvo = new Volvo240(0,0);
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void speedFactor() {
        assertTrue(volvo.speedFactor() == 1.25);
    }

    @Test
    public void incrementSpeedAlittle() {
        volvo.startEngine();
        volvo.incrementSpeed(2);
        assertTrue(volvo.getCurrentSpeed() == 2.6);
    }
    @Test
    public void incrementSpeedTooMuch() {
        volvo.startEngine();
        volvo.incrementSpeed(80);
        assertTrue(volvo.getCurrentSpeed() == 100);
    }

    @Test
    public void decrementSpeedAtHighSpeed() {
        volvo.startEngine();
        volvo.incrementSpeed(78); //set speed to 97.6
        volvo.decrementSpeed(50); // 97.6-62.5
        assertTrue(volvo.getCurrentSpeed() > 35);
        assertTrue(volvo.getCurrentSpeed() < 35.1);

    }
    @Test
    public void decrementSpeedAtEngineStart() {
        volvo.startEngine();
        volvo.decrementSpeed(20);
        assertTrue(volvo.getCurrentSpeed() == 0);
    }

}