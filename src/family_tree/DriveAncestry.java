package family_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class DriveAncestry {
    public static void main(String[] args) {
       FamilyTree ft = configureTree();
        TreeMap<String, Person> treeEntries = ft.getAllPeople();
        showAllPeople(treeEntries);
        ft = AddNewPerson( ft );   // ToDO Add Maggie born 2021 with bart and lisa siblings
                                     // and homer and marge (Mom and dad)
        System.out.printf("\n------------------- All people with Maggie");
        TreeMap<String, Person> treeEntries2 = ft.getAllPeople();
        showAllPeople(treeEntries2);
        String name = "Jackie";
        System.out.printf("\n--- Showing Direct Descendants of %s", name);
        ShowDirectDescendants(name, ft);
        name = "Abbey";
        System.out.printf("\n---Showing Direct Descendants of %s", name);
        ShowDirectDescendants(name, ft);
        name = "Lisa";
        System.out.printf("\n---Showing Direct Descendants of %s", name);
        ShowDirectDescendants(name, ft);

        name = "Mona";
        System.out.printf("\n---Showing Direct Descendants of %s", name);
        ShowDirectDescendants(name, ft);

        name="Homer";
        System.out.printf("\n---Showing Siblings of %s", name);
        ShowMySiblings(name, ft);
        name="Maggie";
        System.out.printf("\n---Showing Siblings of %s", name);
        ShowMySiblings(name, ft);

        name="Clancy";
        System.out.printf("\n---Showing Siblings of %s", name);
        ShowMySiblings(name, ft);

//        showThisPersonsTree(treeEntries, "Marge");


    }

    private static void ShowMySiblings(String person, FamilyTree ft) {
        ArrayList<Person> siblings = new ArrayList<>();
        Person root = ft.getThisPerson(person);
        for(Person parent : root.getParent()) {
            for(Person child : parent.getChildren()) {
                if(!siblings.contains(child)) {
                    siblings.add(child);
                }
            }
        }
        siblings.remove(root);
        if(siblings.size() == 0) {
            System.out.printf("\n  %s has no siblings", root.getName());
        }
        for(Person sibling : siblings) {
            System.out.printf("\n  %s", sibling.getName());
        }
    }

    private static void ShowDirectDescendants(String ancestor, FamilyTree ft) {
        Person root = ft.getThisPerson(ancestor);
        if (root.getSpouse() != null) {
            System.out.printf("\n%s is married to %s", root.getName(), root.getSpouse().getName());
        }
        if(root.getChildren().size() != 0) {
            for (Person child1 : root.getChildren()) {
                System.out.printf("\n  %s", child1.getName());
                for (Person child2 : child1.getChildren()) {
                    System.out.printf("\n    %s", child2.getName());
                }
            }
        } else {
            System.out.printf("\n  %s has no direct descendants", root.getName());
        }
    }

    private static FamilyTree AddNewPerson(FamilyTree ft) {
        Scanner s = new Scanner(System.in);
        int birthYear = 0;
        System.out.printf("\n\n---- Adding new person to family tree ----");
        System.out.printf("\nPlease enter first name of new person -> ");
        String name = s.next();
        System.out.printf("Please enter their year of birth -> ");
        try {
            birthYear = s.nextInt();
        } catch (Exception e) {
            System.out.printf("\nNot a valid year!");
        }
        System.out.printf("Please enter their mother's first name -> ");
        String mother = s.next();
        System.out.printf("Please enter their father's first name -> ");
        String father = s.next();
        System.out.printf("Please enter their spouse's first name or 'n' if there is no spoise -> ");
        String spouse = s.next();

        Person newPerson = new Person(name, birthYear);
        if(!spouse.equalsIgnoreCase("n")) {
            Person pSpouse = ft.getThisPerson(spouse);
            newPerson.setSpouse(pSpouse);
            pSpouse.setSpouse(newPerson);
            ft.addPerson(spouse, pSpouse);
        }

        ft.addPerson(name, newPerson);

        Person pMother = ft.getThisPerson(mother);
        Person pFather = ft.getThisPerson(father);

        ft.addParent(name, pMother);
        ft.addParent(name, pFather);
        ft.addChild(father, newPerson);
        ft.addChild(mother, newPerson);

        return ft;
    }



    private static void showAllPeople(TreeMap<String, Person> treeEntries) {
        for (String name : treeEntries.keySet()) {
            Person m = treeEntries.get(name);
            System.out.printf("\n%s", m.toString());
        }
    }

    private static void showThisPersonsTree(HashMap<String, Person> treeEntries, String searchPerson) {
        System.out.printf("\n =--------------");
        if (treeEntries.containsKey(searchPerson)) {
            Person targetPerson = treeEntries.get(searchPerson);
            boolean gotMoreToDo = true;
            while (gotMoreToDo) {
                gotMoreToDo = false;
            }
        } else {
            System.out.printf("\n The Person:%s does not exist", searchPerson);
        }
        for (String name : treeEntries.keySet()) {
            Person m = treeEntries.get(name);
            System.out.printf("\n%s", m.toString());
        }
    }


    private static FamilyTree configureTree() {
        FamilyTree ft = new FamilyTree();
        Person nullPerson = null;
        Person nullSpouse = null;

        ArrayList<Person> nullChildrenList = new ArrayList<>();
        ArrayList<Person> nullParentList = new ArrayList<>();

        // bart and lisa and maggie
        Person bart = new Person( "Bart", 2020);
        ft.addPerson( "Bart", bart);
        Person lisa = new Person( "Lisa", 2021);
        ft.addPerson("Lisa", lisa);

        Person marge = new Person( "Marge", 1990);
        Person homer = new Person( "Homer", 1991);
        homer.spouse = marge;
        marge.spouse = homer;
        ft.addPerson("Homer", homer);
        ft.addPerson( "Marge", marge);

        ft.addChild("Marge", bart);
        ft.addChild("Marge", lisa);
        ft.addChild("Homer", bart);
        ft.addChild("Homer", lisa);

        ft.addParent("Bart", marge);
        ft.addParent("Bart", homer);
        ft.addParent( "Lisa", marge);
        ft.addParent( "Lisa", homer);

        // Lets add Marges Sisters
        Person Selma = new Person( "Selma", 1991 );
        ft.addPerson("Selma", Selma);
        Person patty = new Person( "Patty", 1992 );

        ft.addPerson("Patty", patty);

        Person clancy = new Person( "Clancy", 1960 );
        Person jackie = new Person( "Jackie", 1961 );
        clancy.spouse = jackie;
        jackie.spouse = clancy;
        ft.addPerson("Clancy", clancy);
        ft.addPerson( "Jackie", jackie);
        ft.addChild("Clancy", Selma);
        ft.addChild("Clancy", marge);
        ft.addChild("Clancy", patty);

        ft.addChild("Jackie", Selma);
        ft.addChild("Jackie", marge);
        ft.addChild("Jackie", patty);

        ft.addParent("Marge", clancy);
        ft.addParent("Marge", jackie);
        ft.addParent("Patty", clancy);
        ft.addParent("Patty", jackie);
        ft.addParent("Selma", clancy);
        ft.addParent("Selma", jackie);

        //Homers side
        Person herbert = new Person("Herbert", 1954);
        Person abbey = new Person("Abbey", 1964);
        ft.addPerson("Herbert", herbert);
        ft.addPerson("Abbey", abbey);

        Person mona = new Person("Mona", 1929);
        Person grampa = new Person("Grampa", 1927);
        ft.addPerson("Grampa", grampa);
        ft.addPerson("Mona", mona);

        ft.addParent("Herbert", grampa);
        ft.addParent("Abbey", grampa);
        ft.addParent("Homer", mona);
        ft.addParent("Homer", grampa);
        ft.addChild("Mona", homer);
        ft.addChild("Grampa", homer);
        ft.addChild("Grampa", herbert);
        ft.addChild("Grampa", abbey);


        return ft;
    }


}

