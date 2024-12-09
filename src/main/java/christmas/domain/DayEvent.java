package christmas.domain;

public class DayEvent {
    private int discount;

    public DayEvent(Date date, Order order) {
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
        if (date % 7 != 1 && date % 7 != 2) {
            if (Menu.valueOf(menu).getType().equals("디저트")) {
                return 2023;
            }
        }
        return 0;
    }

}
