package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class BaseballNumber {

    private static final int COMPUTER_MIN_RANDOM_NUMBER = 1;
    private static final int COMPUTER_MAX_RANDOM_NUMBER = 9;
    private static final int NUMBER_COUNT = 3;
    private String numberText;

    private BaseballNumber() {
    }

    public BaseballNumber(String numberText) {
        if (!isValidNumber(numberText)) {
            throw new IllegalArgumentException("잘못된 수를 입력하셨습니다. 입력한 수:" + numberText);
        }
        this.numberText = numberText;
    }

    public static BaseballNumber createRandomNumber() {
        StringBuilder numberText = new StringBuilder();
        while (isNotThreeLength(numberText.toString())) {
            addNumber(numberText);
        }
        return new BaseballNumber(numberText.toString());
    }

    private static void addNumber(StringBuilder numberText) {
        int no = Randoms.pickNumberInRange(COMPUTER_MIN_RANDOM_NUMBER, COMPUTER_MAX_RANDOM_NUMBER);
        if (hasContainNumber(no, numberText.toString())) {
            return;
        }
        numberText.append(no);
    }

    private static boolean hasContainNumber(int no, String target) {
        return target.contains(String.valueOf(no));
    }

    private static boolean isValidNumber(String text) {
        if (isNotThreeLength(text)) {
            return false;
        }

        if (!isNumber(text)) {
            return false;
        }

        return !isDuplicateNumber(text);
    }

    private static boolean isNotThreeLength(String text) {
        return text.length() != NUMBER_COUNT;
    }

    private static boolean isDuplicateNumber(String text) {
        return Arrays.stream(text.split(""))
                     .distinct()
                     .count() != NUMBER_COUNT;
    }

    private static boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String getNumberText() {
        return numberText;
    }
}
