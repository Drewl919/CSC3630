package CSC_Practice;


import java.util.ArrayList;
import java.util.Collections;

public class TransactionalProblem {
    public static void main(String[] args) {
        ArrayList<Item> myWork = new ArrayList<>();
        myWork.add(new Item(100, 5, 1));
        myWork.add(new Item(200, 9, 3));
        myWork.add(new Item(300, 23, 2));
        myWork.add(new Item(250, 12, 3));
        myWork.add(new Item(400, 9, 1));

        Collections.sort(myWork);
        for(Item item : myWork) {
            System.out.printf("\nID:%s  Trans Time:%s  Priority:%s", item.id, item.trans_time, item.priority);
        }
    }
    public static class Item implements Comparable<Item>{
        public int id;
        public int trans_time;
        public int priority;

        public Item(int id, int trans_time, int priority) {
            this.id = id;
            this.trans_time = trans_time;
            this.priority = priority;
        }


        @Override
        public int compareTo(Item o) {
            if(o.priority < this.priority) {
                return 1;
            } else if (o.priority > this.priority) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
