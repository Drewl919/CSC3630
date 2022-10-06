import java.util.ArrayList;

public class InClass_9_6_AL {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>(100);
        myList.add(99);
        myList.add(100);
        myList.add(99);
        showAver(myList);
        int second = myList.get(1);
        for(int i=0; i< myList.size(); i++) {
            System.out.printf("\n item:%s", myList.get(i));
        }

    }

    private static void showAver(ArrayList<Integer> myList) {
        Integer sum = 0;
        for(Integer item : myList) {
            sum += item;
        }
        double aver = 0;
        if(myList.size() != 0){
            aver = (double)sum / myList.size();
        }
        System.out.printf("\n Ct:%s Aver:%s", myList.size(), aver);
    }
}
