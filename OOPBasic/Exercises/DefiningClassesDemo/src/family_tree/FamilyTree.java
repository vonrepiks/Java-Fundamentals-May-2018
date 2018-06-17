package family_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyTree {
    private Person mainPerson;
    private List<Person> children;
    private List<Person> parents;

    public FamilyTree() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setMainPerson(Person mainPerson) {
        this.mainPerson = mainPerson;
    }

    public void addParent(Person parent) {
        this.parents.add(parent);
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        StringBuilder familyTree = new StringBuilder();

        familyTree.append(this.mainPerson).append(System.lineSeparator())
                .append("Parents:").append(System.lineSeparator())
                .append(this.parents.size() == 0 ? "" : String.format("%s%s", this.parents.stream().map(Person::toString).collect(Collectors.joining(System.lineSeparator())), System.lineSeparator()))
                .append("Children:").append(System.lineSeparator())
                .append(String.format("%s", this.children.stream().map(Person::toString).collect(Collectors.joining(System.lineSeparator()))));

        return familyTree.toString();
    }
}
