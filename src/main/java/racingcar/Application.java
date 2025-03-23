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

        // 입력한 자동차 이름 개수만큼 이동 거리 정보를 담을 배열 생성
        int[] distance = new int[CarNamesArr.length];

        // 시도할 횟수는 몇 회인가요?
        System.out.println("시도할 횟수는 몇 회인가요?");
        // 시도 횟수 입력
        String tryTimeStr = Console.readLine();
        // 시도 횟수를 int 형으로 변환하여 저장
        int tryTime = Integer.parseInt(tryTimeStr);

        // 경주 시작 함수
        startRacing(CarNamesArr, distance, tryTime);

        // 경기 결과 출력 함수
        printWinner(CarNamesArr, distance);
    }

    public static String[] inputCarNames(String CarNames) {
        return CarNames.split(",");
    }

    public static void startRacing(String[] CarNamesArr, int[] distance, int tryTime) {
        for (int i = 0; i < CarNamesArr.length; i++) {
            distance[i] = 0;
        }

        System.out.println("\n실행 결과\n");

        for (int i = 0; i < tryTime; i++) {
            // 차량 이동
            goForward(distance);
            // 경기 내용 출력 함수
            printDistance(CarNamesArr, distance);
            System.out.println();
        }
    }

    // 이동 현황을 배열에 업데이트하는 함수
    public static void goForward(int[] distance) {
        for (int i = 0; i < distance.length; i++) {
            distance[i] = distance[i] + isGo();
        }
    }

    // 이동 여부를 판별하는 함수
    public static int isGo() {
        int go = 0;
        if(Randoms.pickNumberInRange(0,9)>=MOVING_FORWARD) go = 1;
        return go;
    }

    // 이동 현황을 출력하는 함수
    public static void printDistance(String[] CarNamesArr, int[] distance) {
        for (int i = 0; i < CarNamesArr.length; i++) {
            System.out.print(CarNamesArr[i] + " : ");
            printDash(distance, i);
            System.out.println();
        }
    }

    public static void printDash(int[] distance, int i) {
        for (int j = 0; j < distance[i]; j++) {
            System.out.print("-");
        }
    }

    public static void printWinner(String[] CarNamesArr, int[] distance) {
        boolean isPrinted = false;
        int max = maxDistance(distance);
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < distance.length; i++) {
            if(isPrinted && distance[i]==max) System.out.print(", ");
            if(distance[i]==max) {
                System.out.print(CarNamesArr[i]);
                isPrinted = true;
            }
        }
    }

    public static int maxDistance(int[] distance) {
        int max = 0;
        for (int i = 0; i < distance.length; i++) {
            if(distance[i] > max) max = distance[i];
        }
        return max;
    }
}