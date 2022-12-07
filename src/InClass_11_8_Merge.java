import java.util.Arrays;

public class InClass_11_8_Merge {
    public static void main(String[] args) {
        int[] myList = {7, 4, 9, 2, 10, 1, 3};
        System.out.printf("\nUnsorted: %s", Arrays.toString(myList));

        sort(myList);
        System.out.printf("\nSorted: %s", Arrays.toString(myList));
    }

    private static void sort(int[] myList) { // takes nlog(n) to do merge sort
        if(myList.length<2) return;
        // find mid
        int mid = myList.length/2;
        // do left half ---------
        int[] left_half = new int[mid];
        for(int i=0; i<mid; i++) {
            left_half[i] = myList[i];
        }
        int[] right_half = new int[myList.length - mid];
        for(int i=mid; i<myList.length; i++) {
            right_half[i-mid] = myList[i];
        }
        sort(left_half);
        sort(right_half);
        merge(myList, left_half, right_half);

    }

    private static void merge(int[] myList, int[] left_half, int[] right_half) {
        int i=0, j=0, k=0;
        // ?? what is the purpose of i, j, and k???
        while(i<left_half.length && j<right_half.length) {
            if(left_half[i] < right_half[j]) {
                myList[k++] = left_half[i++];
            } else {
                myList[k++] = right_half[j++];
            }
        }
        while(i < left_half.length) {
            myList[k++] = left_half[i++];
        }
        while(j < right_half.length) {
            myList[k++] = right_half[j++];
        }
    }
}
