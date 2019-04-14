import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingCarTest {

    private RacingCar racingCar;
    private int MAX = 9;
    private int MIN = 4;

    @Before
    public void setup() {
        String name = "test";
        racingCar = new RacingCar("test");
    }

    @Test
    public void getPosition_성공() {

        assertEquals(racingCar.getPosition(), 0);
    }

    @Test
    public void getPosition_실패() {
        assertNotEquals(racingCar.getPosition(), 1);
    }

    @Test
    public void getName_성공() {
        assertEquals(racingCar.getName(), "test");
    }

    @Test
    public void getName_실패() {
        assertNotEquals(racingCar.getName(), "NotTest");
    }

    @Test
    public void move_성공() {
        int previousPosition = racingCar.getPosition();
        racingCar.move(4);
        int currentPosition = racingCar.getPosition();
        assertEquals(currentPosition - previousPosition, 1);
    }

    @Test
    public void move_실패() {
        int previousPosition = racingCar.getPosition();
        racingCar.move(4);
        int currentPosition = racingCar.getPosition();
        assertNotEquals(currentPosition - previousPosition, 0);
    }

    @Test
    public void isMovable_성공() {

        assertTrue(racingCar.isMovable(MAX));
        assertTrue(racingCar.isMovable(MIN));
    }

    @Test
    public void isMovable_실패() {
        assertFalse(racingCar.isMovable(MAX + 1));
        assertFalse(racingCar.isMovable(MIN - 1));
    }





}
