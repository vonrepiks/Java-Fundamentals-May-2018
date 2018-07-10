package custom_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {

    private List<T> elements;

    public MyArrayList() {
        this.elements = new ArrayList<>();
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < this.elements.size();
    }

    @Override
    public void add(T element) {
        this.elements.add(element);
    }

    @Override
    public T remove(int index) {
        if (this.isValidIndex(index)) {
            return this.elements.remove(index);
        }
        return null;
    }

    @Override
    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    @Override
    public void swap(int firstIndex, int secondIndex) {
        if (this.isValidIndex(firstIndex) && this.isValidIndex(secondIndex)) {
            T temp = this.elements.get(firstIndex);
            this.elements.set(firstIndex, this.elements.get(secondIndex));
            this.elements.set(secondIndex, temp);
        }
    }

    @Override
    public int countGreaterThan(T element) {
        return this.elements.stream()
                .filter(e -> e.compareTo(element) > 0)
                .collect(Collectors.toList())
                .size();
    }

    @Override
    public T getMax() {
        return this.elements.stream()
                .max(Comparator.naturalOrder())
                .get();
    }

    @Override
    public T getMin() {
        return Collections.min(this.elements);
    }

    @Override
    public Iterable<T> getElements() {
        return this.elements;
    }
}
