package card_game;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        this.seedDeck();
    }

    private void seedDeck() {
        for (SuitType suitType : SuitType.values()) {
            for (RankType rankType : RankType.values()) {
                Card card = new Card(rankType, suitType);
                this.cards.add(card);
            }
        }
    }

    public boolean contains(Card card) {
        return this.cards
                .stream()
                .anyMatch(innerCard ->
                        innerCard.getRankType().equals(card.getRankType()) &&
                                innerCard.getSuitType().equals(card.getSuitType()));
    }

    public void remove(Card card) {
        this.cards.removeIf(innerCard ->
                innerCard.getRankType().equals(card.getRankType()) &&
                        innerCard.getSuitType().equals(card.getSuitType()));
    }
}
