package CSC_Practice;

import java.util.ArrayList;
import java.util.TreeMap;

public class Practice2 {
    public static void main(String[] args) {
        int n = 30;

        TreeMap<Integer, Node> transactions = getTransactionsHash();

    }

    private static TreeMap<Integer, Node> getTransactionsHash() {
        TreeMap<Integer, Node> transaction = new TreeMap<>();
        ArrayList<Node> actions = getTransactions();
        for(Node action : actions) {
            transaction.put(action.priority, action);
        }
        return transaction;
    }

    private static ArrayList<Node> getTransactions() {
        ArrayList<Node> actions = new ArrayList<>();
        actions.add(new Node(100, 5, 1));
        actions.add(new Node(200, 9, 3));
        actions.add(new Node(300, 23, 2));
        actions.add(new Node(250, 12, 3));
        actions.add(new Node(400, 9, 1));
        return actions;
    }

    static class Node {
        int id;
        int trans_time;
        int priority;

        Node(int id, int trans_time, int priority) {

        }
    }
}
