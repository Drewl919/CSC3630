import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ShoppingClassTest1 {
    @Test
    public void creationTest() {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item("Banana", 2, false));
        list.add(new Item("Chicken", 4, false));
        list.add(new Item("Pizza", 6, false));
        list.add(new Item("Donut", 4, true));
        list.add(new Item("Apples", 6, false));
        list.add(new Item("Grapes", 6, true));
        ShoppingList_9_6 sl = new ShoppingList_9_6(list);
        assertEquals(6, sl.getSize());
    }

    @Test
    public void gotItemsTest() {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item("Banana", 2, false));
        list.add(new Item("Chicken", 4, false));
        list.add(new Item("Pizza", 6, false));
        list.add(new Item("Donut", 4, true));
        list.add(new Item("Apples", 6, false));
        list.add(new Item("Grapes", 6, true));
        ShoppingList_9_6 sl = new ShoppingList_9_6(list);
        assertEquals(4, sl.getItems(false).size());
        assertEquals(2, sl.getItems(true).size());
    }

    @Test
    public void gotItemsTestNone() {
        ArrayList<Item> list = new ArrayList<>();
        ShoppingList_9_6 sl = new ShoppingList_9_6(list);
        assertEquals(0, sl.getItems(false).size());
        assertEquals(0, sl.getItems(true).size());
    }

    @Test
    public void renameItem() {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item("Banana", 2, false));
        list.add(new Item("Chicken", 4, false));
        list.add(new Item("Pizza", 6, false));
        list.add(new Item("Donut", 4, true));
        list.add(new Item("Apples", 6, false));
        list.add(new Item("Grapes", 6, true));
        ShoppingList_9_6 sl = new ShoppingList_9_6(list);
        sl.renameItem("Donut", "Longjohn");
        assertEquals(3, sl.nameIsThere("Longjohn"));
        assertEquals(-1, sl.nameIsThere("Donut"));
    }

    @Test
    public void nameIsThereTest() {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item("Banana", 2, false));
        list.add(new Item("Chicken", 4, false));
        list.add(new Item("Bacon", 6, false));
        list.add(new Item("Donut", 4, true));
        list.add(new Item("Sausage", 6, false));
        list.add(new Item("Grapes", 6, true));
        ShoppingList_9_6 sl = new ShoppingList_9_6(list);
        assertEquals(2, sl.nameIsThere("bacon"));
        assertEquals(-1, sl.nameIsThere("Pizza"));
        sl.addItem("Pizza", 10, false);
        assertEquals(6, sl.nameIsThere("Pizza"));
        assertEquals(5, sl.nameIsThere("Grapes"));
    }

    @Test
    public void removeItemTest() {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item("Banana", 2, false));
        list.add(new Item("Chicken", 4, false));
        list.add(new Item("Bacon", 6, false));
        list.add(new Item("Donut", 4, true));
        list.add(new Item("Sausage", 6, false));
        list.add(new Item("Grapes", 6, true));
        ShoppingList_9_6 sl = new ShoppingList_9_6(list);
        assertEquals(2, sl.nameIsThere("bacon"));
        sl.removeItem("Bacon");
        assertEquals(-1, sl.nameIsThere("Bacon"));
        assertEquals(3, sl.getItems(false).size());
        assertEquals(2, sl.getItems(true).size());
    }

    @Test
    public void addItemTest() {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item("Chicken", 4, true));
        list.add(new Item("Bacon", 6, false));
        list.add(new Item("Donut", 4, true));
        list.add(new Item("Sausage", 6, false));
        list.add(new Item("Grapes", 6, true));
        ShoppingList_9_6 sl = new ShoppingList_9_6(list);
        assertEquals(-1, sl.nameIsThere("Banana"));
        sl.addItem("Banana", 2, false);
        assertEquals(5, sl.nameIsThere("Banana"));
        assertEquals(3, sl.getItems(false).size());
        assertEquals(3, sl.getItems(true).size());
    }



}
