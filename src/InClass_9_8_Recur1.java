
public class InClass_9_8_Recur1 {
    public static void main(String[] args) {
        int n = 32;
        int fact1 = factorial1(n);
        System.out.printf("\n Factorial of N:%s is %s", n, fact1);

        int fact2 = FactorialRecur(n);
        System.out.printf("\n Factorial of N:%s is %s", n, fact2);
    }

    public static int FactorialRecur(int n) {
        if (n<=1) {
            return 1;
        } else {
            return n*FactorialRecur(n-1);
        }
        //return ret
    }

    private static int factorial1(int n) {
        int ret = 1;
        for(int i=n; i>0; i--) {
            ret *= i;
        }


        return ret;
    }
}
