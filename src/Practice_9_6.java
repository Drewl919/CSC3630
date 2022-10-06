public class Practice_9_6 {
    public static void main(String[] args) {
        String inLine = "Jack,22,95.5";
        String[] toks = inLine.split(",");
        double newVal = Double.parseDouble(toks[2]);
        System.out.printf("\n newVal: %s", newVal);

        int[] scores = {45, 99, 66, 55, 22};
        int sum = getOddSum(scores);
        System.out.printf("\n\n Sum of odd numbers: %s", sum);

        // If each character takes 1 byte ...
        // How many memory locations does this take?
        String tok = "A";
        tok += "B";

    }

    private static int getOddSum(int[] scores) {
        int sum = 0;
        for(int score : scores) {
            if(score%2 != 0) {
                sum+=score;
            }
        }
        return sum;
    }


}
