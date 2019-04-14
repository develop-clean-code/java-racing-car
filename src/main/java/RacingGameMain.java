import java.lang.reflect.Array;
import java.util.ArrayList;

public class RacingGameMain {

    public static void main(String[] args) {

        // 자동차 이름 입력
        String carNames = RacingGameView.inputNameView(
                "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        int tryCount = RacingGameView.inputCountView(
                "시도할 회수는 몇회인가요?");

        RacingCarNameParser racingCarNameParser = new RacingCarNameParser();

        String[] parsedCarNames = racingCarNameParser.parse(carNames);
        int carCount = racingCarNameParser.getNameCount();

        RacingCarGame racingCarGame = new RacingCarGame(carCount, tryCount, parsedCarNames);

        for (int i = 0; i < tryCount; i++) {
            racingCarGame.tryMove(); // 자동차 경주 시작
        }

        RacingGameView.printCars(racingCarGame); // 자동차 출력

        ArrayList<String> winners = racingCarGame.selectWinners(); // 우승자 선별

        RacingGameView.printWinners(winners); // 우승자 베너 출력

    }
}
