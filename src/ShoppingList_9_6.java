import java.util.ArrayList;

public class ShoppingList_9_6 {
    ArrayList<Item> shoppingList = new ArrayList<>();

    public ShoppingList_9_6(ArrayList<Item> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public void addItem(String name, int ct, boolean gotIt) {
        int indx = nameIsThere( name );
        if ( indx != -1 ) {
            shoppingList.remove(indx);
            Item nItem = new Item( name, ct, gotIt);
            shoppingList.add( nItem);

        } else {
            Item item = new Item( name, ct, gotIt);
            shoppingList.add(item);
        }
    }

    public  int nameIsThere(String inName ) {
        int theItemInx = -1;
        int ct = 0;
        for( Item item : shoppingList ){
            if( item.getName().equalsIgnoreCase(inName)){
                theItemInx = ct;
                break;
            }
            ct++;
        }
        return theItemInx;
    }

    public void showList() {
        for ( Item item : shoppingList){
            System.out.printf(item.toString());
        }
    }

    public int getSize() {
        return shoppingList.size();
    }

    public boolean removeItem(String inItem) {
        boolean gotIt = false;
        int ct = 0;
        for ( Item item : shoppingList){
            if ( item.getName().equalsIgnoreCase(inItem)){
                shoppingList.remove(ct);
                gotIt = true;
                break;
            }
            ct++;
        }
        return gotIt;
    }

    public ArrayList<Item> getItems(boolean gotIt) {
        ArrayList<Item> tempArray = new ArrayList<>();
        for(Item item : shoppingList) {
            if(item.getGotIt() == gotIt)
                tempArray.add(item);
        }
        return tempArray;
    }

    public boolean renameItem ( String origName, String newName ){
        int indx = nameIsThere(origName);
        boolean nameChanged = false;
        if ( indx != -1 ) {
            shoppingList.get(indx).setName(newName);
            nameChanged = true;
        }
        return nameChanged;
    }
}

class Item {
    private String name;
    private int ct;
    private boolean gotIt;

    public Item(String name, int ct, boolean gotIt) {
        this.name = name;
        this.ct = ct;
        this.gotIt = gotIt;
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

    public boolean getGotIt() {
        return gotIt;
    }

    public void setGotIt(boolean gotIt) {
        this.gotIt = gotIt;
    }

    @Override
    public String toString() {
        return "\nName:"+getName()+" ct:"+getCt()+" got it:"+getGotIt();
    }
}
