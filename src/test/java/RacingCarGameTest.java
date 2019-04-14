import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RacingCarGameTest {

    private int carNum;
    private int tryNum;
    private RacingCarGame racingCarGame;

    @Before
    public void setup() {
        this.carNum = 3;
        this.tryNum = 5;
        String[] carNames = {"pobi", "crong", "honux"};

        racingCarGame = new RacingCarGame(carNum, tryNum, carNames);
    }

    @Test
    public void tryMove_성공() {

        boolean[] moveSuccess = new boolean[3];
        moveSuccess = racingCarGame.tryMove();

        racingCarGame.getRacingCarList().forEach(racingCar ->
                assertTrue(racingCar.move(6)));
    }

    @Test
    public void tryMove_실패() {
        racingCarGame.getRacingCarList().forEach(racingCar ->
                assertFalse(racingCar.move(0)));
    }

    @Test
    public void selectWinners_성공_케이스1() {
        racingCarGame.getRacingCarList().get(0).setPosition(10);
        racingCarGame.getRacingCarList().get(1).setPosition(0);
        racingCarGame.getRacingCarList().get(2).setPosition(0);

        ArrayList<String> winnerList =  racingCarGame.selectWinners();

        assertEquals(winnerList.size(), 1);
        assertEquals(winnerList.get(0), "pobi");
    }

    @Test
    public void selectWinners_성공_케이스2() {
        racingCarGame.getRacingCarList().get(0).setPosition(10);
        racingCarGame.getRacingCarList().get(1).setPosition(10);
        racingCarGame.getRacingCarList().get(2).setPosition(0);

        ArrayList<String> winnerList =  racingCarGame.selectWinners();

        assertEquals(winnerList.size(), 2);
        assertEquals(winnerList.get(0), "pobi");
        assertEquals(winnerList.get(1), "crong");
    }


}
