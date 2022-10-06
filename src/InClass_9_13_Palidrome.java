
public class InClass_9_13_Palidrome {
    public static void main(String[] args) {
        String str1 = "aba";
        System.out.printf("\nis Palidrome:%s", isPalin1(str1));

        System.out.printf("\n\nis Palidrome Recursive:%s", isPalinRecur(str1));
    }

    public static Boolean isPalinRecur(String str1) {
        System.out.printf("\nFL1: str1:%s", str1);
        if(str1.length()<=1) {
            return true;
        } else if (str1.charAt(0) != str1.charAt(str1.length()-1)) {
            System.out.printf("\n FL2 retFalse:ch1:%s ch2:%s", str1.charAt(0), str1.length()-1);
            return false;
        } else {
            return isPalinRecur(str1.substring(1, str1.length()-1));
        }
    }

    private static Boolean isPalin1(String str1) {
        Boolean isPalin = true;
        int check = str1.length()-1;
        for(int i=0; i<str1.length()/2; i++) {
            if(str1.charAt(i) != str1.charAt(check)) {
                return false;
            }
            check = check - 1;
        }
        return isPalin;
    }
}
