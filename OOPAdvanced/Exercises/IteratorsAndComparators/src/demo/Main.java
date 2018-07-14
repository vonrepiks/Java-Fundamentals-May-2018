package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Course course = new Course();

        for (Student student : course) {

        }

        for (int i = 0; i < 5;) {
            i++;
        }

        for(Iterator<Student> iterator = course.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
            iterator.remove();
        }
    }
}
