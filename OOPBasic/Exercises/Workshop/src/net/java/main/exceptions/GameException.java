package net.java.main.exceptions;

abstract class GameException extends Exception {

    protected GameException(String message) {
        super(message);
    }
}
