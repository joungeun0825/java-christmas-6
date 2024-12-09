package christmas.view;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
}
