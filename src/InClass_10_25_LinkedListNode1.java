public class InClass_10_25_LinkedListNode1 {
    Node1 head = null;
//    Node1 tail = null;
    int size = 0;
    public InClass_10_25_LinkedListNode1() {
        this.head = null;
        this.size = 0;
    }
    public int getSize() {
        return this.size;
    }
    public void addNode ( String s2){
        if ( size == 0 ){
            head = new Node1(s2);
            head.next = null;
            this.size = 1;
            System.out.printf("FLsize:%s", size);
        } else {
            Node1 oldHead = head;
            this.head  = new Node1(s2);
            this.head.next = oldHead;
            //head.next = n2;
            this.size += 1;
            System.out.printf("\n -- size:%s", size);
        }


    }
    public Node1 getLLHead( ){
        return head;
    }
    public boolean isItInThere(String item) {
        // ToDo Write a method that returns true or false
        Node1 theNode = this.head;
        boolean gotIt = false;
        while( theNode  != null ) {
            if ( theNode.value.equals( item )) {
                return true;
            }
            theNode = theNode.next;
        }
        return gotIt;
    }
    public Node1 removeThisItem( String item) {
//        boolean gotIt = false;
        Node1 theNode = this.head;
        Node1 previousNode = null;

        int ct = 1;
        while( theNode  != null ) {
            if ( theNode.value.equals( item )) {
                System.out.printf("\n FOUND Ct:%s item:%s", ct, theNode.value);
                if ( previousNode == null ){
                    // then it's the first
                    this.size--;
                    this.head = theNode.next;
                    return theNode;
                }
                // not the first
                previousNode.next = theNode.next; //You are on one node, keeping track of the previous node, you link the node before and the node after together.
                this.size--;
                return theNode;
            } else {
                System.out.printf("\n NOT FOUND Ct:%s item:%s", ct, theNode.value);
            }
            // move along the chain
            previousNode = theNode;
            theNode = theNode.next;
            ct++;
        }
        return null;
    }
}
class Node1 {
    public String value;
    public Node1 next = null;

    Node1( String v) {
        value = v;
    }

}