package team.onlapus.ua.exceptions;

public class InvalidTimeException extends Exception{

    private final String message;

    public InvalidTimeException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
