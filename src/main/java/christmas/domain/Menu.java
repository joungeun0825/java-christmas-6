package christmas.domain;

public enum Menu {
    양송이수프("애피타이저", 6000), 타파스("애피타이저", 5500), 시저샐러드("애피타이저", 8000),
    티본스테이크("메인", 55000), 바비큐립("메인", 54000), 해산물파스타("메인", 35000), 크리스마스파스타("메인", 25000),
    초코케이크("디저트", 15000), 아이스크림("디저트", 5000),
    제로콜라("음료", 3000), 레드와인("음료", 60000), 샴페인("음료", 25000);

    private final String type;
    private final Integer price;

    Menu(String type, Integer price) {
        this.type = type;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public static void isValidMenu(String itemName) {
        boolean isValid = false;
        for (Menu menu : Menu.values()) {
            if (menu.name().equals(itemName)) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            throw new IllegalArgumentException();
        }
    }


}
