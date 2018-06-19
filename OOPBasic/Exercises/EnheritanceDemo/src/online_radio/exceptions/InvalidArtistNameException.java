package online_radio.exceptions;

public class InvalidArtistNameException extends InvalidSongException {
    public InvalidArtistNameException(String message) {
        super(message);
    }
}
