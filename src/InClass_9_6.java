
public class InClass_9_6 {
    public static void main(String[] args) {
//        String name = "D";
//        name += "B";
//        StringBuilder nameSB = new StringBuilder("D");
//        nameSB.append("B");
//        nameSB.append(99);
//        System.out.printf("\n Name:%s nameSB:%s", name, nameSB.toString()); //need .toString() because otherwise, you will be outputting an object, not the string
        int n = 1000000;

        String name = "D";
        appendToString(n, name);

        String name2 = "D";
        appendToStringBuilder(n, name2);
    }

    private static void appendToString(int n, String name) {
        long startTime = System.currentTimeMillis(); //Counts the number of milliseconds since January 1, 1970, EpsochTime
        for(int i=0; i<n; i++) {
            name += "A";
        }
        long endTime = System.currentTimeMillis(); //Counts the number of milliseconds since January 1, 1970, EpsochTime
        System.out.printf("\n STRING N:%s time:%s", n, endTime-startTime);
    }

    private static void appendToStringBuilder(int n, String name) {
        long startTime = System.currentTimeMillis(); //Counts the number of milliseconds since January 1, 1970, EpsochTime
        StringBuilder sb = new StringBuilder(name);
        for(int i=0; i<n; i++) {
            sb.append("A");
        }
        long endTime = System.currentTimeMillis(); //Counts the number of milliseconds since January 1, 1970, EpsochTime
        System.out.printf("\n SB N:%s time:%s", n, endTime-startTime);
    }
}
