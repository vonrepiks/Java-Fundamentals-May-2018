package demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Course implements Iterable<Student> {

    private List<Student> students;

    public Course() {
        this.students = new ArrayList<>();
    }

    @Override
    public Iterator<Student> iterator() {
        return new CourseIterator();
    }

    private final class CourseIterator implements Iterator<Student> {

        private int cursor;

        CourseIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return students.size() - 1 > this.cursor;
        }

        @Override
        public Student next() {
            return students.get(this.cursor++);
        }
    }
}
