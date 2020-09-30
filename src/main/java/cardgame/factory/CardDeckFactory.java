package cardgame.factory;

import cardgame.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CardDeckFactory {

    public CardDeck createCardDeck(CardDeckType type) {
        Objects.requireNonNull(type, "type must not be null!");
        switch (type) {
            case STANDARD:
                List<Card> cards = new ArrayList<>(52);
                for (CardSuit cardSuit : CardSuit.values()) {
                    for (CardType cardType : CardType.values()) {
                        cards.add(new Card(cardType, cardSuit));
                    }
                }
                return new StandardCardDeck(cards);
        }

        throw new RuntimeException("Never get here!");
    }

}
