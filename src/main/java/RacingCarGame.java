import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

    public static final int MAX_MOVE_FORWARD_NUM = 9;
    public static final int MIN_MOVE_FORWARD_NUM = 4;
    private int time;
    private List<Integer> carPositions = new ArrayList<>();

    private int carNum;
    private int tryNum;
    private Random random;

    public RacingCarGame(int carNum, int tryNum) {
        random = new Random();
        this.carNum = carNum;
        this.tryNum = tryNum;
    }

    public void run() {

        carPositions = move();

        for (int i = 0; i < carNum; i++) {
            System.out.println(positionToString(carPositions.get(i)));
        }
    }

    public String positionToString(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public List<Integer> move() {
        List<Integer> carPositions = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            RacingCar racingCar = tryMoveCar();
            carPositions.add(racingCar.getPosition());
        }
        return carPositions;
    }

    public RacingCar tryMoveCar() {
        RacingCar racingCar = new RacingCar(MAX_MOVE_FORWARD_NUM, MIN_MOVE_FORWARD_NUM);
        for (int i = 0; i < tryNum; i++) {
            racingCar.tryMove();
        }
        return racingCar;
    }
}
