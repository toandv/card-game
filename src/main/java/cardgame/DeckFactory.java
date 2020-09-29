package cardgame;

import java.util.ArrayList;
import java.util.List;

public class DeckFactory {

    public static Deck createDeck() {
        List<Card> cards = new ArrayList<>(52);
        for (Suit suit : Suit.values()) {
            for (CardType cardType : CardType.values()) {
                cards.add(new Card(cardType, suit));
            }
        }
        return new Deck(cards);
    }

}
