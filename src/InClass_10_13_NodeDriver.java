

public class InClass_10_13_NodeDriver {
    public static void main(String[] args) {
//        Node node1 = new Node("Apple");
//        node1.next = null;
//
//        Node node2 = new Node("Baker");
//        node2.next = null;
//        node1.next = node2;
//
//        Node node3 = new Node("Charlie");
//        node3.next = null;
//        node2.next = node3;
//
//        Node node4 = new Node("Dog");
//        node4.next = null;
//        node3.next = node4;

//-------------------Lets do this in stack order
        Node node1 = new Node("Apple");
        node1.next = null;
        Node head = node1;

        Node node2 = new Node("Baker");
        node2.next = head;
        head = node2;

        Node node3 = new Node("Charlie");
        node3.next = head;
        head = node3;

        Node node4 = new Node("Dog");
        node4.next = head;
        head = node4;

        Node node5 = new Node("Eggs");
        node5.next = head;
        head = node5;

        head = push("Fries", head);

        head = pop(head);
        String topOfStack = peek(head);
        System.out.printf("\n ---------- TOP:%s", topOfStack);

        showNodes(head);

        String needle = "Dog"
;        if(isItInTheList(needle, head)){
            System.out.printf("\n\n Yes, n:%s is there", needle);
        } else {
            System.out.printf("\n\n No, n:%s is not there", needle);
        }


        // Remove Random Node
        head = removeThisNode("Baker", head);
        System.out.printf("\n------------ Showing nodes without baker");
        showNodes(head);

    }

    private static Node removeThisNode(String tok, Node head ) {
        boolean gotIt = false;
        Node theNode = head;
        Node prevNode = null;
        int ct = 1;
        while ( theNode != null ){
            if ( theNode.value.equalsIgnoreCase( tok )){
                if(prevNode == null) {
                    // edge case if try to remove the head
                    return theNode.next;
                }
                prevNode.next = theNode.next;
            }
            prevNode = theNode;
            theNode = theNode.next;
            ct++;
        }
        return head;
    }

    private static Node pop(Node head) {
        return head.next;
    }

    private static String peek(Node head) {
        return head.value; // O(1) operation
    }

    private static Node push(String tok, Node head) {
        Node theNode = new Node(tok);
        theNode.next = head;
        head = theNode;
        return head;
    }

    private static boolean isItInTheList(String needle, Node head) {
        Node theNode = head;
        while(theNode != null) {
            if(theNode.value.equalsIgnoreCase(needle)) {
                return true;
            }
            theNode = theNode.next;
        }
        return false;
    }

    private static void showNodes(Node head) {
        Node theNode = head;
        int ct = 1;
        while(theNode != null) {
            System.out.printf("\n Node:%s  Ct:%s", theNode.value, ct);
            ct++;
            theNode = theNode.next;
        }
    }
}
