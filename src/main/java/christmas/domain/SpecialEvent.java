package christmas.domain;

public class SpecialEvent {
    private static final String SPECIAL_DISCOUNT = "특별 할인: -%s원";

    private int specialEvent;

    public SpecialEvent(Date date) {
        this.specialEvent = calcDiscount(date);
    }

    private int calcDiscount(Date date) {
        if (date.getDate() % 7 == 3 || date.getDate() == 25) {
            return 1000;
        }
        return 0;
    }

    public int getDiscount() {
        return this.specialEvent;
    }

    @Override
    public String toString() {
        return String.format(SPECIAL_DISCOUNT, String.format("%,d", this.specialEvent));
    }
}
