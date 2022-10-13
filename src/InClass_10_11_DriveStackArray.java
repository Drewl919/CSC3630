

public class InClass_10_11_DriveStackArray {
    public static void main(String[] args) throws IllegalAccessException {
        StackArray sa = new StackArray();
        sa.push(12);
        sa.push(22);// this is O(n) to grow the array
        sa.push(32);
        sa.push(42);


        System.out.printf("\n Size:%s", sa.getSize());
        System.out.printf("\n Top:%s", sa.peek());
        System.out.printf("\n Popped:%s", sa.pop());

    }
}
