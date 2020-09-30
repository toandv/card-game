package io.github.toandv.cardgame;

import io.github.toandv.cardgame.model.Game;
import io.github.toandv.cardgame.model.Player;

public class App {

    public static void main(String[] args) {
        Game game = new Game(4);
        game.play();
        System.out.println("\n*****************ALL PLAYERS********************");
        for (Player player : game.getPlayers()) {
            System.out.println(player);
        }
        System.out.println("************************************************\n");
        if (game.hasWinner()) {
            System.out.println("***************WINNER OF THE GAME*************");
            System.out.println(game.getWinner());
        } else {
            System.out.println("GAME HAS NO WINNER DUE TO NO CARDS LEFT FOR DRAWING");
        }
        System.out.println("**********************************************");
    }

}
