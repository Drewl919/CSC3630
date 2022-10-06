import java.util.ArrayList;

public class InClass_9_6_ShoppingDriver {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Banana", 6, false));
        items.add(new Item("Coconut", 2, false));
        items.add(new Item("Apple", 12, true));
//        sl.shoppingList.add(new sl.shoppingList.Item("Hot Dog", 22)); // Does not work, there is an inner class
        ShoppingList_9_6 sl = new ShoppingList_9_6(items);
        System.out.printf("\nWe have %s", sl.getItems(false).size());

        System.out.printf("\nName changed:%s", sl.renameItem("Apple", "Pineapple"));
        sl.showList();
    }
}
