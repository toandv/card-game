package cardgame;

import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(4);
        game.play();
        System.out.println(game.getWinner());
        System.out.println(game.getPlayers().stream().map(p -> p.getTotalScore()).collect(Collectors.toList()));
    }

}
