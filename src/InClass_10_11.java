import java.util.*;

public class InClass_10_11 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Auto>> autos = new HashMap<String, ArrayList<Auto>>();

        String deleteThese = "Red";
        Deque<String> myD = new ArrayDeque<>();
        Deque<String> myD2 = new LinkedList<>();

        Auto newAuto = new Auto("Honda", "Accord", "Good", "Good", "Blue");
        String a = "Chevy";
        if(autos.containsKey(a)) {
            ArrayList<Auto> chevies = autos.get(a);
//            ArrayList<Auto> newChevies = deleteThisColor(deleteThese, chevies);
//            autos.put(a, newChevies);
        }

        // Add new Chevy
        if(autos.containsKey(a)) {
            ArrayList<Auto> chevies = autos.get(a);
            chevies.add(newAuto);
            autos.put(a, chevies);
        }

        final String b = "Chevy";
        for(int i=0; i<autos.size(); i++) { //Time complexity: O(n), the size of the hashmap
            for(int j=0; j<b.length()/1; j++) { //Time complexity: O(n^2), if the length is a fixed amount, then it would be O(n)
                System.out.printf("\n Blah");
            }
        }
    }
}
