package team.onlapus.ua.exceptions;

public class InvalidTimeException extends Exception {
    private final String message;

    public InvalidTimeException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}