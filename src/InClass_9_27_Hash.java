import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class InClass_9_27_Hash {
    public static void main(String[] args) {
        HashSet<Integer> myNumbs = new HashSet<>();
        HashSet<Double> prices = new HashSet<>();
        HashSet<String> names = new HashSet<>();

        TreeSet<String> myOtherNames = new TreeSet<>();
        LinkedHashSet<String> mylinkers = new LinkedHashSet<>();

        myNumbs.add(22);
        myNumbs.add(44);
        myNumbs.add(1);
        myNumbs.remove(44);
        if(myNumbs.contains(44)) {
            System.out.printf("\n Yes we got 44");
        } else {
            System.out.printf("\n No got it");
        }

        for(int n : myNumbs) {
            System.out.printf("\n n:%s", n);
        }




    }
}
