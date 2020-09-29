package cardgame;

public class Main {

    public static void main(String[] args) {

        Deck deck = DeckFactory.createDeck();

        deck.shuffle();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);

    }

}
