package cardgame;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(4);
        game.play();
        System.out.println(game.getWinner());
    }

}
