package family_tree;

public class DriveAncestry_11_22 {
    public static void main(String[] args) {
        FamilyTree_11_22 ft = configureTree();
        showAllPeople(ft);
    }

    private static void showAllPeople(FamilyTree_11_22 ft) {
        for(String name : ft.tree.keySet()) {
            Person_11_22 p = ft.tree.get(name);
            System.out.printf("\n%s",p.toString());
        }
    }

    private static FamilyTree_11_22 configureTree() {
        FamilyTree_11_22 ft = new FamilyTree_11_22();
        Person_11_22 bart = new Person_11_22("Bart", 2020);
        ft.addPerson("Bart", bart);

        Person_11_22 lisa = new Person_11_22("Lisa", 2021);
        ft.addPerson("Lisa", lisa);

        Person_11_22 marge = new Person_11_22("Marge", 1990);
        ft.addPerson("Marge", marge);
        ft.addChild("Marge", lisa);
        ft.addChild("Marge", bart);

        Person_11_22 jackie = new Person_11_22("Jackie", 1960);
        ft.addPerson("Jackie", jackie);
        ft.addChild("Jackie", marge);

        Person_11_22 clancy = new Person_11_22("Clancy", 1961);
        clancy.spouse = jackie;
        ft.addPerson("Clancy", clancy);
        ft.addChild("Clancy", marge);

        jackie.spouse = clancy;
        ft.addPerson("Jackie", jackie);

        //Adding parents to marge
        marge.addParent(jackie);
        marge.addParent(clancy);
        ft.addPerson("Marge", marge);


        Person_11_22 selma = new Person_11_22("Selma", 1961);
        ft.addPerson("Selma", selma);
        selma.addParent(jackie);
        selma.addParent(clancy);

        return ft;
    }
}
