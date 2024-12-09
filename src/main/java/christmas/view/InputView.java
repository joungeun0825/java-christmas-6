package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Menu;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ERROR_DATE_MESSAGE = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    private static final String INPUT_MENU_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String ERROR_MENU_MESSAGE = "유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static int inputDate() {
        System.out.println(INPUT_DATE_MESSAGE);
        try {
            return processDate(Console.readLine().trim());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputDate();
        }
    }

    public static Map<String, Integer> inputMenu() {
        System.out.println(INPUT_MENU_MESSAGE);
        try {
            return processMenu(Console.readLine().trim());
        } catch (Exception e) {
            OutputView.printErrorMessage(ERROR_MENU_MESSAGE);
            return inputMenu();
        }
    }

    private static int processDate(String input) {
        checkNonEmptyInput(input);
        int date = parseInt(input);
        checkBound(date);
        return date;
    }

    private static Map<String, Integer> processMenu(String input){
        return Arrays.asList(input.split(","))
                .stream()
                .map(String::trim)
                .map(item -> item.split("-"))
                .peek(item -> Menu.isValidMenu(item[0]))
                .collect(Collectors.toMap(
                        item -> item[0],
                        item -> parseInt(item[1]))
                );
    }

    private static void checkNonEmptyInput(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException(ERROR_DATE_MESSAGE);
        }
    }

    private static void checkBound(int date) {
        if (1 > date || date > 31) {
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
