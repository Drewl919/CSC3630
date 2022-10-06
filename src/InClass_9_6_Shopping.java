import java.util.ArrayList;

public class InClass_9_6_Shopping {
    ArrayList<Item> shoppingList = new ArrayList<>();
//    ArrayList<String> shppingList = new ArrayList<>();
//    ArrayList<Integer> shppingListCt = new ArrayList<>();

    public InClass_9_6_Shopping(ArrayList<Item> shppingList) {
        this.shoppingList = shppingList;
    }

    public InClass_9_6_Shopping(){

    }

    public void addItem(String name, int ct) {
        Item item = new Item(name, ct);
        shoppingList.add(item);
    }

    public void showList() {
        for(Item item : shoppingList) {
            System.out.printf("\n Item:%s Ct:%s", item.getName(), item.getCt());
        }
    }

    public boolean removeItem(String inItem) {
        boolean gotIt = false;
        int ct = 0;
        for(Item item : shoppingList) {
            if(item.getName().equals(inItem)) {
                shoppingList.remove(ct);
                gotIt = true;
                break;
            }
            ct++;
        }
        return gotIt;
    }


    private class Item {
        private String name;
        private int ct;

        public Item(String name, int ct) {
            this.name = name;
            this.ct = ct;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCt() {
            return ct;
        }

        public void setCt(int ct) {
            this.ct = ct;
        }

        @Override
        public String toString() {
            return "Item :" +
                    "name='" + name + '\'' +
                    ", ct=" + ct;
        }
    }
}
