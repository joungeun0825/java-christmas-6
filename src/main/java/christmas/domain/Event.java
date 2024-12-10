package christmas.domain;

public class Event {
    private static final String TOTAL_DISCOUNT = "\n<총혜택 금액>\n";
    private static final String PRICE_FORMAT = "-%,d원";
    private static final String NOTHING = "없음";

    private ChristmasEvent christmasEvent;
    private DayEvent dayEvent;
    private WeekendEvent weekendEvent;
    private SpecialEvent specialEvent;
    private ChampagneEvent champagneEvent;

    public Event(ChristmasEvent christmasEvent, DayEvent dayEvent,
                 WeekendEvent weekendEvent, SpecialEvent specialEvent,
                 ChampagneEvent champagneEvent) {
        this.christmasEvent = christmasEvent;
        this.dayEvent = dayEvent;
        this.weekendEvent = weekendEvent;
        this.specialEvent = specialEvent;
        this.champagneEvent = champagneEvent;
    }

    public ChristmasEvent getChristmasEvent() {
        return this.christmasEvent;
    }

    public DayEvent getDayEvent() {
        return this.dayEvent;
    }

    public WeekendEvent getWeekendEvent() {
        return this.weekendEvent;
    }

    public SpecialEvent getSpecialEvent() {
        return this.specialEvent;
    }

    public ChampagneEvent getChampagneEvent() {
        return this.champagneEvent;
    }

    public int getEventPrice() {
        int totalDiscount = this.christmasEvent.getChristmasDiscount() + this.dayEvent.getDiscount() + this.weekendEvent.getDiscount() + this.specialEvent.getDiscount();
        if (this.champagneEvent.getChampagne()) {
            totalDiscount += 25000;
        }
        return totalDiscount;
    }

    public int getTotalDiscount(){
        return this.christmasEvent.getChristmasDiscount() + this.dayEvent.getDiscount() + this.weekendEvent.getDiscount() + this.specialEvent.getDiscount();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append(TOTAL_DISCOUNT);
        if(this.getEventPrice() == 0){
            return sb.append(NOTHING).toString();
        }
        sb.append(String.format(PRICE_FORMAT, this.getEventPrice()));
        return sb.toString();
    }
}
