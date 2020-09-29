package cardgame;

public class MaxPlayersExceededException extends RuntimeException {

    public MaxPlayersExceededException(String message) {
        super(message);
    }
}
