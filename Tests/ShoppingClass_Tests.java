
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class ShoppingClass_Tests {
    @Test
    public void creationTest() {
        ArrayList<Item> shoppingList = new ArrayList<>();
        shoppingList.add(new Item("Banana", 2, false));
        shoppingList.add(new Item("Chicken", 4, false));
        shoppingList.add(new Item("Pizza", 6, false));
        shoppingList.add(new Item("Donut", 4, true));
        shoppingList.add(new Item("Apples", 6, false));
        shoppingList.add(new Item("Grapes", 6, true));
        assertEquals(6, shoppingList.size());
    }

    @Test
    public void addRemoveTest() {
        ArrayList<Item> shoppingList = new ArrayList<>();
        shoppingList.add(new Item("Banana", 2, false));
        shoppingList.add(new Item("Chicken", 4, false));
        shoppingList.add(new Item("Pizza", 6, false));
        shoppingList.add(new Item("Donut", 4, true));
        shoppingList.add(new Item("Apples", 6, false));
        shoppingList.add(new Item("Grapes", 6, true));
        ShoppingList_9_6 sl = new ShoppingList_9_6(shoppingList);
        sl.removeItem("Chicken");
        assertEquals(5, sl.getSize());
    }


    @Test
    public void nameIsThereTest1() {
        ArrayList<Item> shoppingList = new ArrayList<>();
        shoppingList.add(new Item("Banana", 2, false));
        shoppingList.add(new Item("Chicken", 4, false));
        shoppingList.add(new Item("Pizza", 6, false));
        shoppingList.add(new Item("Donut", 4, true));
        shoppingList.add(new Item("Apples", 6, false));
        shoppingList.add(new Item("Grapes", 6, true));
        ShoppingList_9_6 sl = new ShoppingList_9_6(shoppingList);
//        sl.removeItem("Chicken");
//        int ct = sl.nameIsThere("Chicken");
        assertEquals(-1, sl.nameIsThere("Blah"));
        assertEquals(5, sl.nameIsThere("Grapes"));
        assertEquals(2, sl.nameIsThere("Pizza"));
    }

    @Test
    public void gotItemsTest() {
        ArrayList<Item> shoppingList = new ArrayList<>();
        shoppingList.add(new Item("Banana", 2, false));
        shoppingList.add(new Item("Chicken", 4, false));
        shoppingList.add(new Item("Pizza", 6, false));
        shoppingList.add(new Item("Donut", 4, true));
        shoppingList.add(new Item("Apples", 6, false));
        shoppingList.add(new Item("Grapes", 6, true));
        ShoppingList_9_6 sl = new ShoppingList_9_6(shoppingList);
    }
}
