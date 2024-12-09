package christmas.controller;

import christmas.domain.ChristmasEvent;
import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.TotalPrice;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    public static void run() {
        Date date = new Date(InputView.inputDate());
        Order order = new Order(InputView.inputMenu());
        OutputView.printWelcomeMessage(date, order);
        ChristmasEvent christmasEvent = new ChristmasEvent(date);
    }
}
