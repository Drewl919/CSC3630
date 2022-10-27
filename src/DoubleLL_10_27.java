public class DoubleLL_10_27 {
    class Node {
        int item;
        Node previous;
        Node next;

        public Node(int item) {
            this.item = item;
            this.next = null;
            this.previous = null;
        }
    }// Ends node Class within DoubleLL_10_27
    Node head, tail = null;

    public void addNode (int item) {
        Node newNode = new Node(item);
        if(head == null) {
            //It's the first node
            head = newNode;
            tail = newNode;
            head.previous = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
    }
    public void printNodes() {
        Node current = head;
        System.out.printf("\n --- Showing the nodes --- ");
        int ct = 0;
        while (current != null) {
            System.out.printf("\nCt:%s  Item:%s", ++ct, current.item);
            current = current.next;
        }
    }
    public void printNodesInReverse() {
        Node current = tail;
        System.out.printf("\n --- Showing the nodes --- ");
        int ct = 0;
        while (current != null) {
            System.out.printf("\nCt:%s  Item:%s", ++ct, current.item);
            current = current.previous;
        }
    }
    public int popTail() {
        // ToDo: remove the last item
        // Return -99 if not there
        // Else return the value of the last item
        int retVal = 0;
        if(head == null && tail == null) {
            return -99;
        } else if (head == tail && head != null) {
            // 1 item case
            System.out.printf("\n FLAG2");
            retVal = head.item;
            head = null;
            tail = null;
            return retVal;
        } else {
            // more than 1 node
            System.out.printf("FLAG3");
            retVal = tail.item;
            tail = tail.previous;
            tail.next = null;
        }
        return retVal;
    }
}
