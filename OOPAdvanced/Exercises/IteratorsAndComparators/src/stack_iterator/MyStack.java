package stack_iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<T> implements Iterable<T> {
    private static final int INITIAL_CAPACITY = 16;
    private static final String EMPTY_STACK_EXCEPTION_MESSAGE = "No elements";

    private T[] elements;

    private int elementsCount;

    @SuppressWarnings("unchecked")
    public MyStack() {
        this.elements = (T[]) new Object[INITIAL_CAPACITY];
    }

    private void growElementsLength() {
        this.elements = Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    public void push(T element) {
        if (this.elementsCount == this.elements.length) {
            growElementsLength();
        }
        this.elements[this.elementsCount++] = element;
    }

    public T pop() {
        if (this.elementsCount == 0) {
            throw new NoSuchElementException(EMPTY_STACK_EXCEPTION_MESSAGE);
        }
        T element = this.elements[--elementsCount];
        this.elements[elementsCount] = null;
        return element;
    }


    @Override
    public Iterator<T> iterator() {
        return new MyStackIterator();
    }

    private final class MyStackIterator implements Iterator<T> {

        private int cursor;

        MyStackIterator() {
            this.cursor = elementsCount - 1;
        }

        @Override
        public boolean hasNext() {
            return this.cursor >= 0;
        }

        @Override
        public T next() {
            return elements[this.cursor--];
        }
    }
}
