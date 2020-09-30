package cardgame.factory;

import cardgame.model.CardType;
import cardgame.model.Card;
import cardgame.model.CardDeck;
import cardgame.model.CardSuit;

import java.util.ArrayList;
import java.util.List;

public class CardDeckFactory {

    public CardDeck createStandardDeck() {
        List<Card> cards = new ArrayList<>(52);
        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardType cardType : CardType.values()) {
                cards.add(new Card(cardType, cardSuit));
            }
        }
        return new CardDeck(cards);
    }

}
