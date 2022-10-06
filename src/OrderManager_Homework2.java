import java.util.ArrayList;


public class OrderManager_Homework2 {
        ArrayList<OrderItem> orders = new ArrayList<>();

        public OrderManager_Homework2() {
        }
        public void addOrder( OrderItem o){
            orders.add( o );

        }
        public boolean gotThisOrder( int id ){
            // ToDo: Write this method to return O(1) if the id is in the order set
            //
            return false;
        }
        public ArrayList<OrderItem> findOrders(int oId){
            // ToDo: Rewrite this method to operation O(1) instead of O(n)
            ArrayList<OrderItem> retOrder = new ArrayList<>();
            //boolean firstLine = true;
            for( OrderItem o : orders ){
                if ( o.getOrder_id() == oId ){
                    retOrder.add(o);
                }
            }
            return retOrder;
        }
    public ArrayList<OrderItem> getOrdersByState(String inState ){
            //ToDo: Rewrite this method to be more efficent and use a hash
        ArrayList<OrderItem> retOrder = new ArrayList<>();
        //boolean firstLine = true;
        for( OrderItem o : orders ){
            if ( o.getStatus().equals(inState) ){
                retOrder.add(o);
            }
        }
        return retOrder;
    }
    // ToDo: Write a method
    public boolean updateThisOderLineId( int orderId, int lineId, String newStatus ){
            //ToDo: find the orderId and lineId that matches the input and
            //      set status to newStatus.
            // For example:
            //     updateThisOrderLineId( 1233, 1, "staged" )
            // Whould update this this item:
            // From:
            //       1233;1;4;2;shipped;500
            // TO:
            //       1233;1;4;2;staged;500
            // Returns: True -> If the proper item  is found and updated
            //          False -> if cannot find the item OR newStatus is NOT
            //                    new, staged, shipped, picked or delivered.
        return false;
    }
    public ArrayList<Integer> getAllOrderId(){
            ArrayList<Integer> orders = new ArrayList<>();
            // ToDo: Return arrayList of all the unique orderIds
            return orders;

    }
    //
    public boolean AddItemToOrder( int OrderId, int partNum,  int quantity ){
            //ToDo:  Search through the orders for OrderNumer and partNum. If it exists
            //       add the quantity to the exsiting order. However if its status is shipped do not
            //       add it and return false.
            // If the orderNumer and partNum is not found then add the order and set lineNumb to 1, and
            //         status to "new"

            // For example, if the following is the exisiting orders
                //1233;1;4;2;shipped;500
                //1236;1;2;2;shipped;500
                //1236;2;2;1;shipped;200
                //1236;3;4;1;picked;4200
                //1236;4;1;1;shipped;600
            // and your call this method with the following:
            //  orderId=1236 partNum=4 and quantity=2
            // change the last order:
            // from
            //1236;4;1;1;shipped;600
            // to:
            //1236;4;1;3;shipped;600
            // Example2
            //  if the method is called with orderId=4444 partNum=4 and quantity=2
            //  Then add a new order with status new

            return true;
    }
}

