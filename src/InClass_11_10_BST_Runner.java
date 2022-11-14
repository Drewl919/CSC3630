public class InClass_11_10_BST_Runner {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.addNode(50, "Apples");
        bst.addNode(25, "Bananas");
        bst.addNode(35, "Carrots");
        bst.addNode(56, "Donut");
        bst.addNode(58, "Eggs");

        bst.inOrderTraversal(bst.root);
        BSTNode b = bst.findNode(58);
        System.out.printf("Node:%s", b.toString());
    }
}