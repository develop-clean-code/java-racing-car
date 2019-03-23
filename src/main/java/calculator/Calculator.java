package calculator;

import java.util.List;

public class Calculator {

    private List<Integer> numberList;

    boolean isEmptyText(String text) {

        if (text == null) {
            return true;
        }

        if (text == "") {
            return true;
        }

        return false;
    }

    public int add(String text) {

        int result = 0;

        if(isEmptyText(text)) {
            return 0;
        }

        numberList = StringParser.parse(text);

        for (int i = 0;i < numberList.size(); i++) {
            result += numberList.get(i);
        }

        return result;
    }
}
