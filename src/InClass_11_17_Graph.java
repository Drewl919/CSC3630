import java.util.ArrayList;

public class InClass_11_17_Graph {
    public static void main(String[] args) {
        int[][] myMat = new int[5][4];
        ArrayList<ArrayList<Integer>> myList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(5);
        row1.add(10);
        row1.add(15);
        myList.add(row1);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(2);
        row2.add(4);
        row2.add(6);
        row2.add(8);
        myList.add(row2);
        int ct = 0;
        for(ArrayList<Integer> row : myList) {
            System.out.printf("\n Ct:%s", ct++);
            for(Integer item : row) {
                System.out.printf(" item:%s", item);
            }
        }
    }
}
