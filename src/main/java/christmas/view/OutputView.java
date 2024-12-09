package christmas.view;

import christmas.domain.Date;
import christmas.domain.Order;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }

    public static void printWelcomeMessage(Date date, Order order){
        printEventMessage(date);
        printOrder(order);
        printTotalPriceWithoutEvent(order);
    }

    public static void printEventMessage(Date date) {
        System.out.println(date.toString());
    }

    public static void printOrder(Order order){
        System.out.println(order.toString());
    }

    public static void printTotalPriceWithoutEvent(Order order){
        System.out.println(order.getTotalPrice().toString());
    }
}
