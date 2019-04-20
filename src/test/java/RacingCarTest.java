import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class RacingCarTest {

    private RacingCar racingCar;
    private int max = 9;
    private int min = 4;
    private int defaultPosition = 0;
    private Random random;

    @Before
    public void setup() {
        random = new Random();
        racingCar = new RacingCar("name", max, min);
    }

    @Test
    public void getPosition_성공() {
        assertEquals(racingCar.getPosition(), defaultPosition);
    }

    @Test
    public void getPosition_실패() {
        assertNotEquals(racingCar.getPosition(), defaultPosition + 1);
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
    public void tryMove_성공() {
        int previousPosition = racingCar.getPosition();
        racingCar.tryMove(random.nextInt(max - min + 1) + min);
        assertTrue(racingCar.getPosition() == (previousPosition + 1));
    }

    @Test
    public void tryMove_실패() {
        int previousPosition = racingCar.getPosition();
        racingCar.tryMove(random.nextInt(min));
        assertFalse(racingCar.getPosition() == (previousPosition + 1));
    }

    @Test
    public void enableMove_성공() {
        Random random = new Random();
        // random , 범위 테스트일 경우 다 하는게 맞을듯
        for (int i = min; i <= max; i++) {
            assertTrue(racingCar.enableMove(i));
        }
        //assertTrue(racingCar.enableMove(random.nextInt(max - min + 1) + min));
    }

    @Test
    public void enableMove_실패() {
        Random random = new Random();
        assertFalse(racingCar.enableMove(random.nextInt(min)));
    }

    @Test
    public void compareTo_성공() {
        racingCar.move();
        assertEquals(racingCar.compareTo(new RacingCar()), -1);

    }

    @Test
    public void compareTo_실패() {
        assertNotEquals(racingCar.compareTo(new RacingCar()), -1);
    }
}