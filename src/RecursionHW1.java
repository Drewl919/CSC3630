//  Author: Andrew Musielak
//  Course: CSC3630 Fall

import java.util.ArrayList;
import java.util.Arrays;

public class RecursionHW1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbs = new ArrayList<>(Arrays.asList( 5, 10, 15, 20 ));
        int spot = numbs.size();
        int sum = getSum( numbs, spot-1 );
        System.out.printf("sum:%s", sum);


        System.out.printf("\n ---------------");
        String inString = "Purple Apples str pretty Pleasing p";
        char tok = 'p';
        int loc = inString.length()-1;
        int sum2 = 0;
        int ct = getHowMany( inString, tok, sum2, loc);
        System.out.printf("\ngetHowMany ct:%s", ct);
    }

    public static int getHowMany(String inString, char tok, int sum, int loc) {

        if(loc >= 0) {
            if (inString.charAt(loc) == tok) {
                sum = getHowMany(inString, tok, sum+1, loc-1);
            } else {
                sum = getHowMany(inString, tok, sum, loc-1);
            }
        }
        return sum;
    }

    public static int getSum(ArrayList<Integer> numbs, int i) {
        if ((i)<0) {
            return 0;
        } else {
            return numbs.get(i)+getSum(numbs,i-1);
        }
    }
}
