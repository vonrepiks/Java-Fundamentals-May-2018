package custom_annottation;

@CustomEnumAnnotation(category = "Suit", description = "Provides suit constants for a Card class.")
public enum SuitType {

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int value;

    SuitType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
