public class InClass_10_25_LinkedListNodeDriver {
    public static void main(String[] args) {
        InClass_10_25_LinkedListNode1 ll = new InClass_10_25_LinkedListNode1();
        ll.addNode("Apple");
        ll.addNode("Baker");
        ll.addNode("Charlie");
        ll.addNode("Dog");
        if(ll.isItInThere("Baker")) {
            System.out.printf("\n Yes to Baker");
        }
        if(ll.isItInThere("Blah")) {
            System.out.printf("\n Yes to Blah");
        }
        System.out.printf("\n This size:%s", ll.getSize());
        Node1 n = ll.removeThisItem("Charlie");
        System.out.printf("\nNode:%s  Size:%s", n.value, ll.getSize());

        Node1 theNode = ll.getLLHead();

        int i = 0;
        while(theNode != null) {
            System.out.printf("\ni:%s  val:%s", ++i, theNode.value);
            theNode = theNode.next;
        }
    }
}
