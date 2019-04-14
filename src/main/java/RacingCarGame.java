import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

    private int carNum;
    private int tryNum;
    private List<RacingCar> racingCarList = new ArrayList<>();

    private int maxPoistion;

    public RacingCarGame(int carNum, int tryNum, String[] carNames) {
        this.carNum = carNum;
        this.tryNum = tryNum;
        for (int i = 0; i < carNum; i++) {
            RacingCar racingCar = new RacingCar(carNames[i]);
            racingCarList.add(racingCar);
            System.out.println(racingCar);
        }

        maxPoistion = 0;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }


    public boolean[] tryMove() {
        boolean[] moveResult = new boolean[racingCarList.size()];
        Random random = new Random();
        for (int i = 0; i < racingCarList.size(); i++) {
            int randomNumber = random.nextInt(10); // 0 ~ 9 number
            moveResult[i] = racingCarList.get(i).move(randomNumber);
        }

        return moveResult;
    }

    public ArrayList<String> selectWinners() {

        ArrayList<String> resultWinners = new ArrayList<>();

        // 최고의 Position을 구한다.
        for (int i = 0; i < racingCarList.size(); i++) {
            compareMaxPosition(racingCarList.get(i).getPosition());
        }

        // 우승자를 List에 추가한다.
        for (int i = 0; i < racingCarList.size(); i++) {
            addWinner(resultWinners, racingCarList.get(i));
        }

        return resultWinners;
    }

    private void addWinner(ArrayList<String> resultWinners, RacingCar racingCar) {
        if (racingCar.getPosition() == maxPoistion) {
            resultWinners.add(racingCar.getName());
        }
    }


    private void compareMaxPosition(int position) {
        if (maxPoistion < position) {
            maxPoistion = position;
        }
    }
}
