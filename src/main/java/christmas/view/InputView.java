package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ERROR_DATE_MESSAGE = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public static int inputDate() {
        System.out.println(INPUT_DATE_MESSAGE);
        try {
            return processInput(Console.readLine().trim());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputDate();
        }
    }

    private static int processInput(String input) {
        checkNonEmptyInput(input);
        int date = parseInt(input);
        checkBound(date);
        return date;
    }

    private static void checkNonEmptyInput(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException(ERROR_DATE_MESSAGE);
        }
    }

    private static void checkBound(int date) {
        if (1 < date || date > 31) {
            throw new IllegalArgumentException(ERROR_DATE_MESSAGE);
        }
    }

    private static int parseInt(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_DATE_MESSAGE);
        }
    }
}
