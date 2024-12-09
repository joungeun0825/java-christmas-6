package christmas.controller;

import christmas.domain.*;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    public static void run() {
        Date date = new Date(InputView.inputDate());
        Order order = new Order(InputView.inputMenu());
        OutputView.printWelcomeMessage(date, order);
        applyEvent(date, order);
    }

    private static void applyEvent(Date date, Order order) {
        ChristmasEvent christmasEvent = new ChristmasEvent(date);
        DayEvent dayEvent = new DayEvent(date, order);
        WeekendEvent weekendEvent = new WeekendEvent(date, order);
        SpecialEvent specialEvent = new SpecialEvent(date);
        ChampagneEvent champagneEvent = new ChampagneEvent(order);
    }
}
