public class BST {
    public BSTNode root = null;

    public void inOrderTraversal(BSTNode focusNode) {
        if(focusNode != null) {
            inOrderTraversal(focusNode.leftChild);
            System.out.printf("\n node:%s   Val:%s", focusNode.key, focusNode.name);
            inOrderTraversal(focusNode.rightChild);
        }
    }

    public BSTNode findNode(int key) {
        // Return either null or  the node
        BSTNode focusNode = root;
        while (focusNode.key != key) {
            if(key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if(focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    public void addNode(int key, String name) {
        BSTNode newNode = new BSTNode(key, name);
        if(root == null) {
            root = newNode;
        } else {
            // we already have a root
            BSTNode focusNode = root;
            BSTNode parent = root;
            int loopCt = 0;
            while (true) {
                parent = focusNode;
                if(key < focusNode.key) {
                    // going to go left
                    focusNode = focusNode.leftChild;

                    if(focusNode == null) {
                        // leftChild has no children
                        // Set parent to newNode
                        System.out.printf("\nTo the left CT:%s  focus:%s", loopCt++, parent.key);

                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    // got to go right
                    focusNode = focusNode.rightChild;
                    if(focusNode == null) {
                        //rightChild has no children
                        // Set parent to newNode
                        System.out.printf("\nTo the right CT:%s  focus:%s", loopCt++, parent.key);

                        parent.rightChild = newNode;
                        return;
                    }
                }
            }//Ends while statement
        }// Ends else statement
    }// ends add node
}