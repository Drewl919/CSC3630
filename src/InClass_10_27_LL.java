import java.util.Queue;

public class InClass_10_27_LL {
    public static void main(String[] args) {
        System.out.printf("\nStarting...");
        DoubleLL_10_27 dll = new DoubleLL_10_27();
        dll.addNode(12);
        dll.addNode(15);
        dll.addNode(25);
        dll.printNodes();
        dll.printNodesInReverse();

        int popItem = dll.popTail();
        System.out.printf("\n Popped:%s", popItem);
        dll.printNodes();

        System.out.println();
        DoubleLL_10_27 dll2 = new DoubleLL_10_27();
//        dll2.addNode(12);
        int popItem2 = dll2.popTail();
        System.out.printf("\n Popped:%s", popItem2);
        dll2.printNodes();
    }
}
