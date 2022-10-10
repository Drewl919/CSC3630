import lib.FileIO;
import java.io.FileNotFoundException;
import java.util.*;

public class OrderManager_Homework2 {
    HashSet<OrderItem> orders = new HashSet<>();

    public OrderManager_Homework2() {
    }
    public void addOrder( OrderItem o){
        orders.add( o );
    }

    public void getOrdersFromFile(String fName) throws FileNotFoundException {
        FileIO fio = new FileIO(fName);
        fio.setFileData();
        ArrayList<String> inLines = fio.getFileData();
        boolean firstLine = true;
        for(String line : inLines) {
            if(firstLine) {
                firstLine = false;
                continue;
            }
            String[] toks = line.split(";");
            try {
                int oId = Integer.parseInt(toks[ 0 ]);
                int lId = Integer.parseInt(toks[ 1 ]);
                int pId = Integer.parseInt(toks[ 2 ]);
                int quant = Integer.parseInt(toks[ 3 ]);
                String status = toks[ 4 ];
                double value = Double.parseDouble(toks[ 5 ]);
                orders.add(new OrderItem(oId, lId, pId, quant, status, value));
            } catch (Exception e) {
                System.out.printf("\n Invalid input");
            }
        }
    }

    public boolean gotThisOrder( int id ){
        for(OrderItem item : orders) {
            if(item.getOrder_id()==id) {
                return true;
            }
        }
        return false;
    }

    public HashSet<OrderItem> findOrders(int oId){
        HashSet<OrderItem> retOrder = new HashSet<>();
        orders.forEach(item -> {
            if(item.getOrder_id() == oId) {
                retOrder.add(item);
            }
        });
        return retOrder;
    }

    public HashSet<OrderItem> getOrdersByState(String inState ){
        HashSet<OrderItem> retOrder = new HashSet<>();
        orders.forEach(item -> {
            if(item.getStatus().equalsIgnoreCase(inState)) {
                retOrder.add(item);
            }
        });
        return retOrder;
    }

    public boolean updateThisOderLineId( int orderId, int lineId, String newStatus ) {
        ArrayList<String> status = new ArrayList<>(Arrays.asList("new", "staged", "shipped", "picked", "delivered"));
        if (status.contains(newStatus)) {
            for (OrderItem item : orders) {
                if (item.getOrder_id() == orderId && item.getLine_id() == lineId) {
                    item.setStatus(newStatus);
                    return true;
                }
            }
        }
        return false;
    }

    public HashSet<Integer> getAllOrderId(){
        HashSet<Integer> orderIds = new HashSet<>();
        for(OrderItem order : orders) {
            if(!orderIds.contains(order.getOrder_id())) {
                orderIds.add(order.getOrder_id());
            }
        }
        return orderIds;
    }

    public boolean addItemToOrder( int OrderId, int partNum, int quantity ) {
        boolean retBool = false;
        if (gotThisOrder(OrderId)) {
            for (OrderItem item : orders) {
                if (item.getOrder_id() == OrderId) {
                    if (item.getPartNum() == partNum && !item.getStatus().equalsIgnoreCase("shipped")) {
                        item.setQuantity(quantity+item.getQuantity());
                        retBool = true;
                    }
                }
            }
        } else {
            orders.add(new OrderItem(OrderId, 1, partNum, quantity, "new", 0.0));
            retBool = true;
        }
        return retBool;
    }
}

class OrderProcessorHW2 {
    public static void main(String[] args) throws FileNotFoundException {
        OrderManager_Homework2 ol = new OrderManager_Homework2();
        ol.getOrdersFromFile("data/order_status.csv");
        ol.addOrder(new OrderItem(9999, 1, 444, 12, "new", 0.0));

        System.out.printf("\nAdded item to Order:9999 - %s", ol.addItemToOrder(9999, 444, 12));
        System.out.printf("\nAdded item to Order:1235 - %s", ol.addItemToOrder(1235, 1, 10));

        List<Integer> orderIds = new ArrayList<>();
        for (Integer integer : ol.getAllOrderId()) {
            orderIds.add(integer);
        }
        System.out.printf("\n\n%s", orderIds);

        System.out.printf("\n\nUpdated orderID:999 to shipped - %s", ol.updateThisOderLineId(999, 1, "shipped"));

        System.out.printf("\n\nOrders with status \"Shipped\":");
        showOrders(ol.getOrdersByState("shipped"));

        System.out.printf("\n\nOrders with status \"new\":");
        showOrders(ol.getOrdersByState("new"));

        System.out.printf("\n\nOrders with status \"pizzaHut\":");
        showOrders(ol.getOrdersByState("pizzaHut"));

        System.out.printf("\n\nSearch for order: 9999");
        System.out.printf("\n  There is and order with ID:9999 - %s", ol.gotThisOrder(9999));

        System.out.printf("\nSearch for order: 112358");
        System.out.printf("\n  There is and order with ID:112358 - %s", ol.gotThisOrder(112358));

    }


    private static void showOrders(HashSet<OrderItem> orders) {
        for(OrderItem order : orders){
            System.out.printf("\n  Order: %s", order.toString());
        }
    }
}