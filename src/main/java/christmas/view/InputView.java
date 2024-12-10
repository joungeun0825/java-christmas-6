package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Menu;
import christmas.error.ErrorMessage;
import christmas.validator.InputValidator;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INPUT_MENU_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

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
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(ErrorMessage.INVALID_ORDER_ERROR.getMessage());
            return inputMenu();
        }
    }

    private static int processDate(String input) {
        InputValidator.checkNonEmptyInput(input, ErrorMessage.INVALID_DAY_ERROR.getMessage());
        int date = InputValidator.parseInt(input, ErrorMessage.INVALID_DAY_ERROR.getMessage());
        InputValidator.checkBound(date, 1, 31, ErrorMessage.INVALID_DAY_ERROR.getMessage());
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
                        item -> InputValidator.parseInt(item[1], ErrorMessage.INVALID_ORDER_ERROR.getMessage()))
                );
    }
}
