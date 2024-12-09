package christmas.domain;

public class TotalPrice {
    private static final String TOTAL_PRICE = "<할인 전 총주문 금액>";
    private static final String PRICE_FORMAT = "%,d원";

    private int totalPrice;

    public TotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append(TOTAL_PRICE).append("\n");
        sb.append(String.format(PRICE_FORMAT,totalPrice));
        return sb.toString();
    }
}
