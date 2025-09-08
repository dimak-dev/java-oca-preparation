package homework._2025_09_08__exceptions;

public class NotPositiveArgumentException extends IllegalArgumentException {
    public NotPositiveArgumentException(String message) {
        super(message);
    }

    public NotPositiveArgumentException() {
        super("Integer must be positive!");
    }
}
