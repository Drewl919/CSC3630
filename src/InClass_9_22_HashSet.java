
import java.util.LinkedHashSet;

public class InClass_9_22_HashSet {
    public static void main(String[] args) {
        //No order
//        HashSet<String> names = new HashSet<>();
        //Insertion order
        LinkedHashSet<String> names = new LinkedHashSet<>();
        //Alphabetical order
//        TreeSet<String> names = new TreeSet<>();
        names.add("Jack");
        names.add("Jill");
        names.add("Jaames");
        names.add("Jackie");
        names.add("Jack");
        System.out.printf("Size:%s", names.size());
        for( String name : names ) {
            System.out.printf("\nName: %s", name);
        }
        names.remove("Jill");
        if( names.contains("Jill")) {
            System.out.printf("\n Yep shes there");
        }
    }
}
