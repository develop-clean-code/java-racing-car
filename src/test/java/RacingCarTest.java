import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingCarTest {

    private RacingCar racingCar;
    private int max = 9;
    private int min = 4;

    @Before
    public void setup() {
        racingCar = new RacingCar(9, 4);
    }

    @Test
    public void move_성공() {
        int previousPosition = racingCar.getPosition();
        racingCar.move();
        int currentPosition = racingCar.getPosition();
        assertEquals(currentPosition - previousPosition, 1);
    }

    @Test
    public void move_이전과동일하지않음_성공() {
        int previousPosition = racingCar.getPosition();
        racingCar.move();
        int currentPosition = racingCar.getPosition();
        assertNotEquals(currentPosition, previousPosition);
    }

    @Test
    public void tryMove() {
        int previousPosition = racingCar.getPosition();
        racingCar.tryMove();
        assertTrue(racingCar.getPosition() == previousPosition || racingCar.getPosition() == (previousPosition + 1));
    }

    @Test
    public void enableMove() {
        System.out.println(racingCar.enableMove());
    }
}