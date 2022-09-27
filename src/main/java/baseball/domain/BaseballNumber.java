package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballNumber {

    private static final int COMPUTER_MIN_RANDOM_NUMBER = 1;
    private static final int COMPUTER_MAX_RANDOM_NUMBER = 9;
    private static final int NUMBER_COUNT = 3;
    private String numberText;

    private BaseballNumber() {}

    public BaseballNumber(String numberText) {
        if (!isValidNumber(numberText)) {
            throw new IllegalArgumentException("잘못된 수를 입력하셨습니다. 입력한 수:" + numberText);
        }
        this.numberText = numberText;
    }

    public static BaseballNumber createRandomNumber() {
        StringBuilder numberText = new StringBuilder();
        while (numberText.length() != NUMBER_COUNT) {
            addNumber(numberText);
        }
        return new BaseballNumber(numberText.toString());
    }

    private static void addNumber(StringBuilder numberText) {
        int no = Randoms.pickNumberInRange(COMPUTER_MIN_RANDOM_NUMBER, COMPUTER_MAX_RANDOM_NUMBER);
        if (hasSameNumber(no, numberText.toString())) {
            return;
        }
        numberText.append(no);
    }

    private static boolean hasSameNumber(int no, String target) {
        return target.contains(String.valueOf(no));
    }

    private static boolean isValidNumber(String text) {
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
