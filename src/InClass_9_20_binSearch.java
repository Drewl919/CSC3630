
public class InClass_9_20_binSearch {
    public static void main(String[] args) {
//        int[] myList = {2, 4, 6, 8, 10, 12, 14};
        int[] myList = {4, 2, 9, 1, 3, 14};
        int tok = 2;
        boolean gotIt = linearSearch(myList, tok);
        System.out.printf("\nFound=%s  ctr=%s", gotIt, counter.ctr);
        counter.ctr = 0;
        int result = binarySearch(myList, tok);
        System.out.printf("\nFL2:   Found=%s  result=%s", gotIt, counter.ctr);

    }

    private static int binarySearch(int[] myList, int tok) {
        int low = 0;
        int high = myList.length -1;
        int result = recursiveBinSearch(myList, tok, low, high);
        return result;
    }

    private static int recursiveBinSearch(int[] myList, int tok, int low, int high) {
        int result = -1;
        counter.ctr += 1;
        if(low > high) return -low -1; // Nothing else to check

        int mid = (low +high) / 2;

        if(tok < myList[mid]) {
            recursiveBinSearch(myList, tok, low, mid-1);
        } else if (tok == myList[mid]){
            return mid;
        } else {
            return recursiveBinSearch(myList, tok, mid+1, high);
        }
        return result;
    }

    private static boolean linearSearch(int[] myList, int tok) {
        boolean gotIt = false;
        for(int item : myList) {
            counter.ctr += 1;
            if (item == tok) {
                gotIt = true;
                break;
            }
        }
        return gotIt;
    }



    public class counter {
        public static int ctr = 0;
    }


}
