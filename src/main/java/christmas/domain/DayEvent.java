package christmas.domain;

import java.util.Map;

public class DayEvent {
    private static final String DAY_DISCOUNT = "평일 할인: -%s원";

    private int discount;

    public DayEvent(Date date, Order order) {
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
        if (date % 7 != 1 || date % 7 != 2) {
            if (Menu.valueOf(item).getType().equals("디저트")) {
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
        return String.format(DAY_DISCOUNT, String.format("%,d", this.discount));
    }

}
