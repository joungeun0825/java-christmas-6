package christmas.domain;


public class ChampagneEvent {
    private static final String GIVEAWAY = "\n<증정 메뉴>";
    private static final String CHAMPAGNE = "샴페인 1개";
    private static final String NOTHING = "없음";

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

    public boolean getChampagne(){
        return this.champagne;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append(GIVEAWAY).append("\n");
        if(champagne){
            sb.append(CHAMPAGNE);
            return sb.toString();
        }
        sb.append(NOTHING);
        return sb.toString();
    }
}
