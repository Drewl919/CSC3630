import org.junit.Test;
import java.io.FileNotFoundException;
import java.util.HashSet;
import static org.junit.Assert.assertEquals;

public class OrderManager_Homework2_Tests {

    private String direct = "data/order_status.csv";

    @Test
    public void gotThisOrderTests() throws FileNotFoundException {
        OrderManager_Homework2 ol = new OrderManager_Homework2();
        ol.getOrdersFromFile(direct);
        assertEquals(true, ol.gotThisOrder(1233));
        assertEquals(true, ol.gotThisOrder(1236));
        assertEquals(false, ol.gotThisOrder(1248));
        assertEquals(false, ol.gotThisOrder(1224));
    }

    @Test
    public void AddItemToOrderTest() throws FileNotFoundException {
        OrderManager_Homework2 ol = new OrderManager_Homework2();
        ol.getOrdersFromFile(direct);
        assertEquals(true, ol.addItemToOrder(1235, 1, 5));
        for(OrderItem item : ol.findOrders(1235)) {
            if(item.getPartNum()==1) {
                assertEquals(6, item.getQuantity());
            }
        }
        assertEquals(false, ol.addItemToOrder(1233, 2, 2));
        assertEquals(true, ol.addItemToOrder(1234, 122, 6));
        for(OrderItem item : ol.findOrders(1234)) {
            if(item.getPartNum()==2) {
                assertEquals(8, item.getQuantity());
            }
        }
        assertEquals(false, ol.addItemToOrder(1233, 4, 2));
        assertEquals(false, ol.addItemToOrder(1236, 1, 4));
        assertEquals(false, ol.addItemToOrder(1236, 6, 1));
        assertEquals(true, ol.addItemToOrder(4444, 4, 1));
        assertEquals(true, ol.gotThisOrder(4444));
        for(OrderItem item : ol.findOrders(1235)) {
            if(item.getPartNum()==4) {
                assertEquals(1, item.getQuantity());
            }
        }
        assertEquals(false, ol.addItemToOrder(4444, 5, 1));
    }

    @Test
    public void findOrdersTests() throws FileNotFoundException {
        OrderManager_Homework2 ol = new OrderManager_Homework2();
        ol.getOrdersFromFile(direct);
        assertEquals(4, ol.findOrders(1233).size());
        assertEquals(6, ol.findOrders(1236).size());
        assertEquals(0, ol.findOrders(1248).size());
        assertEquals(0, ol.findOrders(1224).size());
    }

    @Test
    public void updateThisOderLineIdTests() throws FileNotFoundException {
        OrderManager_Homework2 ol = new OrderManager_Homework2();
        ol.getOrdersFromFile(direct);
        assertEquals(true, ol.updateThisOderLineId(1233, 1, "staged"));
        assertEquals(true, ol.updateThisOderLineId(1236, 4, "picked"));
        assertEquals(false, ol.updateThisOderLineId(1233, 1, "pizza"));
        assertEquals(false, ol.updateThisOderLineId(1243, 1, "delivered"));
        assertEquals(false, ol.updateThisOderLineId(1235, 8, "staged"));
    }

    @Test
    public void getAllOrderIdTest() throws FileNotFoundException {
        OrderManager_Homework2 ol = new OrderManager_Homework2();
        ol.getOrdersFromFile(direct);
        HashSet<Integer> tmp = new HashSet<>(5);
        tmp.add(1233);
        tmp.add(1234);
        tmp.add(1235);
        tmp.add(1236);
        tmp.add(1223);
        assertEquals(tmp, ol.getAllOrderId());
        assertEquals(tmp.size(), ol.getAllOrderId().size());
        assertEquals(5, ol.getAllOrderId().size());
    }

    @Test
    public void getOrdersByStateTest() throws FileNotFoundException {
        OrderManager_Homework2 ol = new OrderManager_Homework2();
        ol.getOrdersFromFile(direct);
        assertEquals(9, ol.getOrdersByState("shipped").size());
        assertEquals(0, ol.getOrdersByState("delivered").size());
        assertEquals(3, ol.getOrdersByState("picked").size());
        assertEquals(2, ol.getOrdersByState("staged").size());
        assertEquals(2, ol.getOrdersByState("sourced").size());
    }
}
