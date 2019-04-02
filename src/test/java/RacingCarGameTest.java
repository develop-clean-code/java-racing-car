import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class RacingCarGameTest {

    private int carNum;
    private int tryNum;
    private static Random random;
    private RacingCarGame racingCarGame;

    @BeforeClass
    public static void init() {
        random = new Random();
    }

    @Before
    public void setup() {
        carNum = random.nextInt(10);
        tryNum = random.nextInt(10);

        racingCarGame = new RacingCarGame(carNum, tryNum);
    }

    @Test
    public void tryMoveCar_성공() {
        RacingCar racingCar = racingCarGame.tryMoveCar();
        int position = racingCar.getPosition();
        assertTrue(position <= tryNum || position >= 0);
    }

    @Test
    public void tryMoveCar_실패() {
        RacingCar racingCar = racingCarGame.tryMoveCar();
        int position = racingCar.getPosition();
        assertFalse(position > tryNum || position < 0);
    }

    @Test
    public void move_성공() {
        List<Integer> carPositions = racingCarGame.move();
        carPositions.forEach(carPosition -> {
            assertTrue(carPosition <= tryNum || carPosition >= 0);
        });
    }

    @Test
    public void move_실패() {
        List<Integer> carPositions = racingCarGame.move();
        carPositions.forEach(carPosition -> {
            assertFalse(carPosition > tryNum || carPosition < 0);
        });
    }

    @Test
    public void positionToString_성공() {
        String strPosition = racingCarGame.positionToString(3);
        assertEquals(strPosition, "---");
    }

    @Test
    public void positionToString_실패() {
        String strPosition = racingCarGame.positionToString(3);
        assertNotEquals(strPosition, "----");
    }
}