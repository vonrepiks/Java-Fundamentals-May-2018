package online_radio.exceptions;

public class InvalidSongException extends IllegalArgumentException {
    public InvalidSongException(String message) {
        super(message);
    }
}
