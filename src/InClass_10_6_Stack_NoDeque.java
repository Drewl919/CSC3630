import java.util.ArrayDeque;
import java.util.Deque;

public class InClass_10_6_Stack_NoDeque {
    public static void main(String[] args) {
        Deque<String> myShoppingList = new ArrayDeque<>();
        myShoppingList.push("Apples");
        myShoppingList.push("Bananas");
        myShoppingList.push("Cake");
        myShoppingList.push("Donut");

        String top = myShoppingList.pop();// .pop() gets you the top item and removes it from the stack

        System.out.printf("\n Top:%s", top);
        System.out.printf("\n Size:%s", myShoppingList.size());
        myShoppingList.push("Eggs");
        System.out.printf("\n Top:%s", myShoppingList.peek()); // .peek() gets you the top item without removing it from the stack
        System.out.printf("\n Size:%s", myShoppingList.size());
        showStack(myShoppingList);

    }

    private static void showStack(Deque<String> myShoppingList) {
        System.out.printf("\n---------------------------");
        for(String item : myShoppingList) {
            System.out.printf("\nItem:%s", item);
        }
//        Iterator value = myShoppingList.iterator();
//        // Displaying the values
//        // after iterating through the stack
//        System.out.println("\nThe iterator values are: ");
//        while (value.hasNext()) {
//            System.out.println(value.next());
    }
}
