package christmas.domain;

import java.util.Map;

public class Order {
    private static final String MENU = "\n<주문 메뉴>";
    private static final String ORDER_FORMAT = "%s %d개\n";

    private Map<String, Integer> orders;
    private TotalPrice totalPrice;

    public Order(Map<String, Integer> orders) {
        this.orders = orders;
        totalPrice = new TotalPrice(calcTotalPrice());
    }

    private int calcTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<String, Integer> map : orders.entrySet()) {
            totalPrice += Menu.valueOf(map.getKey()).getPrice() * map.getValue();
        }
        return totalPrice;
    }

    public TotalPrice getTotalPrice() {
        return this.totalPrice;
    }

    public Map<String, Integer> getOrders() {
        return this.orders;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append(MENU).append("\n");

        for (Map.Entry<String, Integer> map : orders.entrySet()) {
            sb.append(String.format(ORDER_FORMAT, map.getKey(), map.getValue()));
        }
        return sb.toString();
    }
}
