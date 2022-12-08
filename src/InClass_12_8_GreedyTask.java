import java.util.Arrays;

public class InClass_12_8_GreedyTask {
    public static void main(String[] args) {
        int[] myList = {1, 5, 2, 4, 2}; //cannot grow past length 5
        int time = 8;
        int result = maxTask(myList, time);
        System.out.printf("\n You can get done: %s", result);


    }

    private static int maxTask(int[] myList, int time) {
        int currentTime = 0;
        int numberOfTasks = 0;
        Arrays.sort(myList);
        for(int item : myList) {
            currentTime += item;
            if(currentTime > time) {
                break;
            }
            numberOfTasks++;
        }
        return numberOfTasks;
    }
}
