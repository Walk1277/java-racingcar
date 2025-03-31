package racingcar;

public class InvalidInputFilter {
    private static final int MAX_INT = 2147483647;
    private static final int MIN_INT = -2147483648;
    public static void isCorrectNames(String[] CarNamesArr) {
        int max = MIN_INT;
        int min = MAX_INT;
        for (int i = 0; i < CarNamesArr.length; i++) {
            if(CarNamesArr[i].length() > max) max = CarNamesArr[i].length();
            if(CarNamesArr[i].length() < min) min = CarNamesArr[i].length();
        }
        if (max > 5 || min < 1 || min > max) {
            throw new IllegalArgumentException("각 자동차 이름의 길이는 1~5 범위 내로 입력하세요.");
        }
    }
}