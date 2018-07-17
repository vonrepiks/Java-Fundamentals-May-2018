package comparing_cards;

public class Card implements Comparable<Card> {

    private RankType rankType;

    private SuitType suitType;

    public Card(String rank, String suit) {
        this.rankType = RankType.valueOf(rank.toUpperCase());
        this.suitType = SuitType.valueOf(suit.toUpperCase());
    }

    public int getPower() {
        return this.rankType.getValue() + this.suitType.getValue();
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.getPower(), other.getPower());
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.rankType, this.suitType);
    }
}
