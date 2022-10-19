import java.util.*;

public class MTQuestionDeque {
    public static void main(String[] args) {
        String myString = "AAABCCCDEEEFGAAAA";
        StringBuilder revString = reverseStringNoDups(myString);
        // The expected output is
        // The String AAABCCCDEEEFGAAAA is GFEDCBA reversed without dupplicate characters
        System.out.printf("\n The String %s is %s reversed without duplicates", myString, revString.toString());
    }

    private static StringBuilder reverseStringNoDups(String myString) {
        StringBuilder retStr = new StringBuilder();
        Deque<Character> str = new ArrayDeque<>();
        char[] newString = myString.toCharArray();
        for(char chr : newString) {
            if(!str.contains(chr)){
                str.push(chr);
            }
        }
        while(!str.isEmpty()) {
            retStr.append(str.pop());
        }
        return retStr;
    }
}

