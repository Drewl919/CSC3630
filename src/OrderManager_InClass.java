import java.util.ArrayList;
import java.util.HashSet;

public class OrderManager_InClass {
    ArrayList<OrderItem> orders = new ArrayList<>();
    HashSet<Integer> byOrderId = new HashSet<>();

    public OrderManager_InClass(ArrayList<OrderItem> orders) {
        this.orders = orders;
        for(OrderItem o : orders) {
            byOrderId.add(o.getOrder_id());
        }
    }

    public ArrayList<OrderItem> findOrder(int inOid) {
        ArrayList<OrderItem> retItems = new ArrayList<>();
        for(OrderItem item : orders) {
            if(item.getOrder_id() == inOid) {
                retItems.add(item);
            }
        }
        return retItems;
    }

    public Boolean gotThisOrder(int inOid) {
        Boolean gotIt = false;
        for(OrderItem item : orders) {
            if(item.getOrder_id() == inOid) {
                return true;
            }
        }
        return gotIt;
    }

    public Boolean gotThisOrderHash(int inOid) {
        Boolean gotIt = false;
        if(byOrderId.contains(inOid)) {
            return true;
        }
        return gotIt;
    }
}
