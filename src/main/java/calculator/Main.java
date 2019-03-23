package calculator;

import java.util.Scanner;

public class Main {

    /**
     * Calculator program의 Entry Point
     *
     * @param args
     */
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        String textInput = null;

        Scanner scanner = new Scanner(System.in);
        System.out.print("계산기 문자열 입력 : ");
        textInput = scanner.nextLine();

        int result = calculator.add(textInput);

        System.out.println("계산 결과 : " + result);

    }
}
