package strategy_pattern.comparators;

import strategy_pattern.Person;

import java.util.Comparator;

public class ComparatorByPersonAge implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return person1.getAge() - person2.getAge();
    }
}
