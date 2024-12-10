package christmas.domain;

import java.util.Map;

public class WeekendEvent {
    private static final String WEEKEND_DISCOUNT = "주말 할인: -%s원";

    private int discount;

    public WeekendEvent(Date date, Order order) {
        this.discount = calcDiscount(date, order);
    }

    private int calcDiscount(Date date, Order order) {
        int discount = 0;
        for (Map.Entry<String, Integer> map : order.getOrders().entrySet()) {
            discount += applyDiscount(date.getDate(), map.getKey(), map.getValue());
        }
        return discount;
    }

    private int applyDiscount(int date, String item, int value){
        if (date % 7 == 1 || date % 7 == 2) {
            if (Menu.valueOf(item).getType().equals("메인")) {
                return value * 2023;
            }
        }
        return 0;
    }

    public int getDiscount() {
        return this.discount;
    }

    @Override
    public String toString() {
        return String.format(WEEKEND_DISCOUNT, String.format("%,d", this.discount));
    }
}
