package christmas.domain;

public class ChristmasEvent {
    private static final String CHRISTMAS_DISCOUNT = "크리스마스 디데이 할인: -%s원";

    private int christmasDiscount;

    public ChristmasEvent(Date date) {
        this.christmasDiscount = calcDiscount(date);
    }

    private int calcDiscount(Date date) {
        if (1 <= date.getDate() && date.getDate() <= 25) {
            return 1000 + ((date.getDate() - 1) * 100);
        }
        return 0;
    }

    public int getChristmasDiscount() {
        return this.christmasDiscount;
    }

    @Override
    public String toString() {
        return String.format(CHRISTMAS_DISCOUNT, String.format("%,d", this.christmasDiscount));
    }
}
