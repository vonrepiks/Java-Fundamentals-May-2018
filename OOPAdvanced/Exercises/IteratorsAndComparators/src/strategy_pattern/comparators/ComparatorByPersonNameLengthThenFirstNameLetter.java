package strategy_pattern.comparators;

import strategy_pattern.Person;

import java.util.Comparator;

public class ComparatorByPersonNameLengthThenFirstNameLetter implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        int comparatorByNameLength = person1.getName().length() - person2.getName().length();
        if (comparatorByNameLength != 0) {
            return comparatorByNameLength;
        }
        return String.valueOf(person1.getName().charAt(0)).compareToIgnoreCase(String.valueOf(person2.getName().charAt(0)));
    }
}
