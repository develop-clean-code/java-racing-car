import java.util.ArrayList;
import java.util.Scanner;

public class RacingGameView {

    public static String inputNameView(String inputType) {

        System.out.println(inputType);
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        return name;
    }

    public static int inputCountView(String inputType) {
        System.out.println(inputType);
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        return count;
    }

    public static void printWinners(ArrayList<String> winners) {

        String winnersBanner = "";
        for (int i = 0; i < winners.size(); i++) {
            winnersBanner += winners.get(i) + ", ";
        }
        winnersBanner = winnersBanner.substring(0, winnersBanner.length() - 2);
        System.out.println(winnersBanner + "가 최종 우승했습니다.");

    }

    public static void printCars(RacingCarGame racingCarGame) {

        System.out.println("실행 결과");
        System.out.println();

        for (int i = 0; i < racingCarGame.getRacingCarList().size(); i++) {

            System.out.print(racingCarGame.getRacingCarList().get(i).getName() + " : ");
            printMovingDistance(racingCarGame.getRacingCarList().get(i).getPosition());
            System.out.println();
        }
    }

    private static void printMovingDistance(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print('-');
        }
    }
}
