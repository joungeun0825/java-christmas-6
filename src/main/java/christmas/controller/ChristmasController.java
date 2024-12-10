package christmas.controller;

import christmas.domain.*;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    public static void run() {
        Date date = new Date(InputView.inputDate());
        Order order = new Order(InputView.inputMenu());
        Event event = applyEvent(date, order);
        OutputView.printWelcomeMessage(date, order, event);
    }

    private static Event applyEvent(Date date, Order order) {
        ChristmasEvent christmasEvent = new ChristmasEvent(date);
        DayEvent dayEvent = new DayEvent(date, order);
        WeekendEvent weekendEvent = new WeekendEvent(date, order);
        SpecialEvent specialEvent = new SpecialEvent(date);
        ChampagneEvent champagneEvent = new ChampagneEvent(order);
        return new Event(christmasEvent, dayEvent, weekendEvent, specialEvent, champagneEvent);
    }
}
