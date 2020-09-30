package io.github.toandv.cardgame.exception;

public class MaxPlayersExceededException extends RuntimeException {

    public MaxPlayersExceededException(String message) {
        super(message);
    }
}
