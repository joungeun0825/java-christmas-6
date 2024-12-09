package christmas.domain;

public class Date {
    private static final String MENU_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

    private int date;

    public Date(int date){
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format(MENU_MESSAGE, this.date);
    }
}
