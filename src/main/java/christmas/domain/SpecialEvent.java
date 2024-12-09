package christmas.domain;

public class SpecialEvent {
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
}
