package family_tree;

import java.util.ArrayList;

public class Person_11_22 {
    String name;
    int birthYear;
    ArrayList<Person_11_22> children = new ArrayList<>();
    ArrayList<Person_11_22> parent = new ArrayList<>();
    Person_11_22 spouse = null;

    public Person_11_22(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public ArrayList<Person_11_22> getChildren() {
        return children;
    }

    public ArrayList<Person_11_22> getParent() {
        return parent;
    }

    public Person_11_22 getSpouse() {
        return spouse;
    }

    public void addParent(Person_11_22 p) {
        this.parent.add(p);
    }

    public void addChild(Person_11_22 p) {
        this.children.add(p);
    }

    public void setSpouse(Person_11_22 p) {
        this.spouse = p;
    }

    @Override
    public String toString() {
        String spouse = null;
        if (this.spouse != null ) spouse = this.spouse.name;
        return "Person:" +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", children=" + children.size() +
                ", parent=" + parent.size() +
                ", spouse=" + spouse ;
    }
}
