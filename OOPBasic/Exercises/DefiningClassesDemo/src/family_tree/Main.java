package family_tree;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = reader.readLine();

        String namePattern = "[A-Z0-9][a-z0-9]+\\s[A-Z0-9][a-z0-9]+";

        Person mainPerson = createPersonByPattern(firstLine, namePattern);

        List<Pair<String, String>> pairs = new ArrayList<>();
        List<Person> people = new ArrayList<>();

        String line;
        while (true) {
            if ("End".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s-\\s");

            switch (tokens.length) {
                case 2:
                    Pair<String, String> pair = new Pair<>(tokens[0], tokens[1]);
                    pairs.add(pair);
                    break;
                case 1:
                    tokens = tokens[0].split("\\s+");
                    String name = tokens[0] + " " + tokens[1];
                    String birthDate = tokens[2];

                    Person person = new Person(name, birthDate);
                    people.add(person);

                    if ((name.equals(mainPerson.getName()) || birthDate.equals(mainPerson.getBirthDate())) && mainPerson.hasNullFields()) {
                        updateMainPerson(mainPerson, name, birthDate);
                    }
                    break;
            }
        }

        FamilyTree familyTree = new FamilyTree();
        familyTree.setMainPerson(mainPerson);

        for (Pair<String, String> pair : pairs) {
            if (pair.getKey().equals(mainPerson.getName()) || pair.getKey().equals(mainPerson.getBirthDate())) {
                people.stream()
                        .filter(p -> p.getName().equals(pair.getValue()) || p.getBirthDate().equals(pair.getValue()))
                        .findFirst()
                        .ifPresent(familyTree::addChild);
            } else if (pair.getValue().equals(mainPerson.getName()) || pair.getValue().equals(mainPerson.getBirthDate())) {
                people.stream()
                        .filter(p -> p.getName().equals(pair.getKey()) || p.getBirthDate().equals(pair.getKey()))
                        .findFirst()
                        .ifPresent(familyTree::addParent);
            }
        }

        System.out.println(familyTree);
    }

    private static void updateMainPerson(Person person, String name, String birthDate) {
        if (person.getName() == null) {
            person.setName(name);
        } else if (person.getBirthDate() == null) {
            person.setBirthDate(birthDate);
        }
    }

    private static Person createPersonByPattern(String value, String namePattern) {
        Person person = new Person();
        if (value.matches(namePattern)) {
            person.setName(value);
        } else {
            person.setBirthDate(value);
        }
        return person;
    }
}
