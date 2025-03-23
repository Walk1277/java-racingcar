package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application { // 퍼블릭 키워드가 붙은 클래스는 파일명과 동일한 클래스명으로 작성
    private static final int MOVING_FORWARD = 4;
    public static void main(String[] args) {
        // 경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
        System.out.println("경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        // 자동차 이름 입력 함수
        String[] CarNamesArr = inputCarNames(Console.readLine());

        // 시도할 횟수는 몇 회인가요?
        System.out.println("시도할 횟수는 몇 회인가요?");
        // 시도 횟수 입력
        String tryTimeStr = Console.readLine();
        // 시도 횟수를 int 형으로 변환하여 저장
        int tryTime = Integer.parseInt(tryTimeStr);
    }

    public static String[] inputCarNames(String CarNames) {
        return CarNames.split(",");
    }
}