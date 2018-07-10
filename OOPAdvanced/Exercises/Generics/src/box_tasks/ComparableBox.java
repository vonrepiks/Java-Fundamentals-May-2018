package box_tasks;

public class ComparableBox<T extends Comparable<T>> implements Comparable<ComparableBox<T>> {
    private T value;

    public ComparableBox() {
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",
                this.value.getClass().getName(),
                this.value);
    }

    @Override
    public int compareTo(ComparableBox<T> other) {
        return this.value.compareTo(other.value);
    }
}
