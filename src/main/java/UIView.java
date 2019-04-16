import java.util.List;
import java.util.Scanner;

public class UIView {
    private Scanner scanner;
    private String inputName;
    private int tryNum;

    public UIView() {
        scanner = new Scanner(System.in);
    }

    public void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        inputName = scanner.next();
    }

    public String getCarNames() {
        return inputName;
    }

    public void inputTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        tryNum = scanner.nextInt();
    }

    public int getTryNum() {
        return tryNum;
    }

    public void printCarPosition(RacingCar racingCar) {
        StringBuilder sb = new StringBuilder();
        sb.append(racingCar.getName());
        sb.append(" : ");
        for (int i = 0; i < racingCar.getPosition(); i++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }

    public void printWinner(List<RacingCar> winners) {
        StringBuilder sb = new StringBuilder();
        for (RacingCar winner : winners) {
            sb.append(winner.getName());
            sb.append(",");
        }
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb.toString());
    }
}
