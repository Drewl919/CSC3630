
public class FirstOne {
    public static void main(String[] args) {
//        System.out.printf("\n Hello World!!!!");
//        int fruitCount = 0;
//        String fruit = "Apples";
//        double price = 2.99;
//        System.out.printf("\n Fruit:%s Ct:%s Price:%s", fruit, fruitCount, price);
//
//        Integer fCount = 0; //Wrapper class for int, primitive
//        Double p = 7.7; //Wrapper class for double

        int[] scores = {75, 85, 95}; //has 3 allocated memory locations
        int largest = getLargest(scores);
        int smallest = getSmallest(scores);
//        int[] scores2 = new int[10]; //created with 10 allocated memory locations

        System.out.printf("\n Largest:%s  Smallest:%s", largest, smallest);

    }

    private static int getSmallest(int[] scores) {
        int smallest = Integer.MAX_VALUE;
        for(int score : scores)
            if(score<smallest)
                smallest = score;
        return smallest;
    }

    private static int getLargest(int[] scores) {
        int largest = Integer.MIN_VALUE;
        for(int score : scores)
            if(largest < score)
                largest = score;
        return largest;
    }




}
