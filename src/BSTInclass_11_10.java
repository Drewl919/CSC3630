//import Prep.BST;

public class BSTInclass_11_10 {
    public static void main(String[] args) {
         BST bst = new BST();
         bst.addNode(  50, "Apples" );
         bst.addNode(  25, "Bananas" );
        bst.addNode(  35, "Carrots" );
        bst.addNode(  56, "Donut" );
        bst.addNode(  58, "Eggs" );

        bst.inOrderTrav( bst.root );

        BSTNode b = bst.findNode( 58 );
        System.out.printf("Node:%s", b.toString());

        BSTNode b2 = bst.findNode( 580 );
        System.out.printf("Node:%s", b2.toString());

//         bst.addNode(  35, "Executive Aid" );
//         bst.addNode(  15, "Office Manager" );


    }
}
