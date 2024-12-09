package christmas.domain;

public class ChampagneEvent {
    private boolean champagne;

    public ChampagneEvent(Order order) {
        this.champagne = applyEvent(order.getTotalPrice().getTotalPrice());
    }

    private boolean applyEvent(int totalPrice) {
        if (totalPrice > 120000) {
            return true;
        }
        return false;
    }
}
