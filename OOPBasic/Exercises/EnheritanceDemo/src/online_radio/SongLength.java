package online_radio;

import online_radio.constants.ExceptionConstants;
import online_radio.exceptions.InvalidSongLengthException;
import online_radio.exceptions.InvalidSongMinutesException;
import online_radio.exceptions.InvalidSongSecondsException;

public class SongLength {
    private int minutes;
    private int seconds;

    public SongLength(String length) {
        this.parseSongLength(length);
    }

    private void parseSongLength(String length) {
        String[] lengthTokens = length.split(":");
        String minutes = lengthTokens[0];
        String seconds = lengthTokens[1];

        if (lengthTokens.length != 2 || !minutes.matches("\\d+") || !seconds.matches("\\d+")) {
            throw new InvalidSongLengthException(ExceptionConstants.INVALID_SONG_LENGTH_EXCEPTION_MESSAGE);
        }

        this.setMinutes(Integer.parseInt(minutes));
        this.setSeconds(Integer.parseInt(seconds));
    }

    private void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException(ExceptionConstants.INVALID_SONG_LENGTH_MINUTES_EXCEPTION_MESSAGE);
        }
        this.minutes = minutes;
    }

    private void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException(ExceptionConstants.INVALID_SONG_LENGTH_SECONDS_EXCEPTION_MESSAGE);
        }
        this.seconds = seconds;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }
}
