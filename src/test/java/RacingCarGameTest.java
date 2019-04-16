import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
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
        carNum = random.nextInt(10) + 1;
        tryNum = random.nextInt(10) + 1;

        racingCarGame = new RacingCarGame();

        String[] carNames = new String[carNum];
        for (int i = 0; i < carNum; i++) {
            carNames[i] = String.valueOf(i);
        }
        racingCarGame.setCarNames(carNames);
        racingCarGame.setTryNum(tryNum);
    }

    @Test
    public void tryMoveCar_성공() {
        RacingCar racingCar = racingCarGame.tryMoveCar("car-name");
        int position = racingCar.getPosition();
        assertTrue(position <= tryNum || position >= 0);
    }

    @Test
    public void tryMoveCar_실패() {
        RacingCar racingCar = racingCarGame.tryMoveCar("car-name");
        int position = racingCar.getPosition();
        assertFalse(position > tryNum || position < 0);
    }

    @Test
    public void move_성공() {
        List<RacingCar> cars = racingCarGame.move();
        cars.forEach(car -> {
            assertTrue(car.getPosition() <= tryNum || car.getPosition() >= 0);
        });
    }

    @Test
    public void move_실패() {
        List<RacingCar> cars = racingCarGame.move();
        cars.forEach(car -> {
            assertFalse(car.getPosition() > tryNum || car.getPosition() < 0);
        });
    }

    @Test
    public void getWinnerPosition_성공() {
        assertEquals(racingCarGame.getWinnerPosition(getRacingCars()), tryNum);
    }

    @Test
    public void getWinnerPosition_실패() {
        assertNotEquals(racingCarGame.getWinnerPosition(getRacingCars()), tryNum + 1);
    }

    @Test
    public void getWinners_성공() {
        List<RacingCar> winners = racingCarGame.getWinners(getRacingCars());
        assertEquals(winners.get(0).getPosition(), tryNum);
        assertEquals(winners.size(), tryNum);
    }

    @Test
    public void getWinners_실패() {
        List<RacingCar> winners = racingCarGame.getWinners(getRacingCars());
        assertNotEquals(winners.get(0).getPosition(), tryNum + 1);
        assertNotEquals(winners.size(), tryNum + 1);
    }

    private List<RacingCar> getRacingCars() {
        List<RacingCar> cars = new ArrayList<>();
        RacingCar racingCar = new RacingCar();
        for (int i = 0; i < tryNum; i++) {
            racingCar.move();
        }
        for (int i = 0; i < tryNum; i++) {
            cars.add(racingCar);
        }

        cars.add(new RacingCar());
        cars.add(new RacingCar());
        return cars;
    }


}