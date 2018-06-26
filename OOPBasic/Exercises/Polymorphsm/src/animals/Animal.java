package animals;

public abstract class Animal extends Mammal {
    private static final String name = "Sharo";

    protected Animal() {
    }

    protected void getSound() {
        System.out.println("Sound");
    }
}
