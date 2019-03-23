package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private static final int CUSTOM_DELIEMETER_TYPE = 1000;
    private static final int DEFAULT_DELIMETER_TYPE = 2000;

    public static int isDelimeterType(String text) {

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return CUSTOM_DELIEMETER_TYPE;
        }

        return DEFAULT_DELIMETER_TYPE;
    }

    public static String getCustomDelimeter(String text) {

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {

            return "|" + m.group(1);
        }

        return "";
    }

    public static int getNumber(String textElement) {

        int number = 0;

        if(isNumeric(textElement)) {
            number = Integer.parseInt(textElement.trim());
        }

        if (number < 0) {
            throw new RuntimeException();
        }

        return number;
    }

    public static boolean isNumeric(String text) {

        try {
            Double.parseDouble(text);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<Integer> parse(String text) {

        List<Integer> result = new ArrayList<>();

        // DEFAULT 구분자
        String delimeter = ",|:";

        // 구분자 체크
        if (isDelimeterType(text) == CUSTOM_DELIEMETER_TYPE) {
            delimeter += getCustomDelimeter(text);
        }

        // 구분자 단위로 피연산자 분할
        String[] stringList = text.split(delimeter);

        // number 추출해서 저장
        for (int i = 0; i < stringList.length; i++) {
            int num = getNumber(stringList[i]);
            result.add(num);
        }

        return result;
    }
}
