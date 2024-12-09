package christmas.domain;

public class WeekendEvent {
    private int discount;

    public WeekendEvent(Date date, Order order) {
        this.discount = calcDiscount(date, order);
    }

    private int calcDiscount(Date date, Order order) {
        int discount = 0;
        for (String menu : order.getOrders().keySet()) {
            discount += applyDiscount(date.getDate(), menu);
        }
        return discount;
    }

    private int applyDiscount(int date, String menu){
        if (date % 7 == 1 || date % 7 == 2) {
            if (Menu.valueOf(menu).getType().equals("메인")) {
                return 2023;
            }
        }
        return 0;
    }
}
