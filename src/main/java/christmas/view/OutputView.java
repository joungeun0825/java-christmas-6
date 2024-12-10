package christmas.view;

import christmas.domain.Date;
import christmas.domain.Event;
import christmas.domain.Order;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    private static final String NOTHING = "없음";

    private static final String EVENT_MESSAGE = "\n<혜택 내역>";
    private static final String GIVE_EVENT = "증정 이벤트: -25,000원\n";

    private static final String FINAL_PRICE = "\n<할인 후 예상 결제 금액>";
    private static final String PRICE_FORMAT = "%,d원\n";

    private static final String BADGE = "<12월 이벤트 배지>";
    private static final String STAR = "별";
    private static final String TREE = "트리";
    private static final String SANTA = "산타";

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }

    public static void printWelcomeMessage(Date date, Order order, Event event) {
        printEventMessage(date);
        printOrder(order);
        printTotalPriceWithoutEvent(order);
        printChampagne(event);
        printEvent(event);
        printTotalDiscount(event);
        printFinalPrice(order, event);
        printBadge(event);
    }

    private static void printEventMessage(Date date) {
        System.out.println(date.toString());
    }

    private static void printOrder(Order order) {
        System.out.println(order.toString());
    }

    private static void printTotalPriceWithoutEvent(Order order) {
        System.out.println(order.getTotalPrice().toString());
    }

    private static void printChampagne(Event event) {
        System.out.println(event.getChampagneEvent().toString());
    }

    private static void printEvent(Event event) {
        System.out.println(EVENT_MESSAGE);
        printChristmasEvent(event);
        printDayEvent(event);
        printWeekendEvent(event);
        printSpecialEvent(event);
        printChampagneEvent(event);
    }

    private static void printChristmasEvent(Event event){
        if (event.getChristmasEvent().getChristmasDiscount() > 0) {
            System.out.println(event.getChristmasEvent().toString());
            return;
        }
        System.out.println(NOTHING);
    }

    private static void printDayEvent(Event event){
        if (event.getDayEvent().getDiscount() > 0) {
            System.out.println(event.getDayEvent().toString());
            return;
        }
        System.out.println(NOTHING);
    }

    private static void printWeekendEvent(Event event){
        if (event.getWeekendEvent().getDiscount() > 0) {
            System.out.println(event.getWeekendEvent().toString());
            return;
        }
        System.out.println(NOTHING);
    }

    private static void printSpecialEvent(Event event){
        if (event.getSpecialEvent().getDiscount() > 0) {
            System.out.println(event.getSpecialEvent().toString());
            return;
        }
        System.out.println(NOTHING);
    }

    private static void printChampagneEvent(Event event){
        if (event.getChampagneEvent().getChampagne()) {
            System.out.println(GIVE_EVENT);
            return;
        }
        System.out.println(NOTHING);
    }

    private static void printTotalDiscount(Event event) {
        System.out.println(event.toString());
    }

    private static void printFinalPrice(Order order, Event event) {
        System.out.println(FINAL_PRICE);
        System.out.println(String.format(PRICE_FORMAT, order.getTotalPrice().getTotalPrice() - event.getTotalDiscount()));
    }

    private static void printBadge(Event event) {
        System.out.println(BADGE);
        if (event.getTotalDiscount() >= 5000 && event.getTotalDiscount() < 10000) {
            System.out.println(STAR);
            return;
        }
        if (event.getEventPrice() >= 10000 && event.getTotalDiscount() < 20000) {
            System.out.println(TREE);
            return;
        }
        if (event.getTotalDiscount() >= 20000) {
            System.out.println(SANTA);
        }

    }

}
