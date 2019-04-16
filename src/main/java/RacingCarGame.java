import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCarGame {

    private UIView uiView;

    public static final int MAX_MOVE_FORWARD_NUM = 9;
    public static final int MIN_MOVE_FORWARD_NUM = 4;
    private List<RacingCar> cars = new ArrayList<>();
    private List<RacingCar> winners = new ArrayList<>();

    private String[] carNames;
    private int tryNum;
    private Random random;

    public RacingCarGame() {
        uiView = new UIView();
        random = new Random();
    }

    public void run() {
        uiView.inputCarNames();
        uiView.inputTryNum();

        setCarNames(uiView.getCarNames().split(","));
        setTryNum(uiView.getTryNum());

        cars = move();
        winners = getWinners(cars);

        for (int i = 0; i < carNames.length; i++) {
            uiView.printCarPosition(cars.get(i));
        }

        uiView.printWinner(winners);
    }

    public void setCarNames(String[] carNames) {
        this.carNames = carNames;
    }

    public void setTryNum(int tryNum) {
        this.tryNum = tryNum;
    }

    public List<RacingCar> move() {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(tryMoveCar(carNames[i]));
        }
        return cars;
    }

    public RacingCar tryMoveCar(String carName) {
        RacingCar racingCar = new RacingCar(carName, MAX_MOVE_FORWARD_NUM, MIN_MOVE_FORWARD_NUM);

        for (int i = 0; i < tryNum; i++) {
            racingCar.tryMove(getRandomNum());
        }
        return racingCar;
    }

    public int getRandomNum() {
        return random.nextInt(MAX_MOVE_FORWARD_NUM + 1);
    }

    public int getWinnerPosition(List<RacingCar> cars) {
        Collections.sort(cars);
        return cars.get(0).getPosition();
    }

    public List<RacingCar> getWinners(List<RacingCar> cars) {
        int winnerPosition = getWinnerPosition(cars);
        return cars.stream().filter(car -> car.getPosition() == winnerPosition).collect(Collectors.toList());
    }
}
