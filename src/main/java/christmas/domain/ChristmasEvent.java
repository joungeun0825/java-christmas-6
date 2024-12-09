package christmas.domain;

public class ChristmasEvent {
    private int christmasDiscount;

    public ChristmasEvent(Date date) {
        this.christmasDiscount = calcDiscount(date);
    }

    private int calcDiscount(Date date) {
        if (1 <= date.getDate() && date.getDate() <= 25) {
            return 1000 * ((date.getDate() - 1) * 100);
        }
        return 0;
    }
}
