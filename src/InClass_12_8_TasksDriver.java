import java.util.ArrayList;
import java.util.Collections;

public class InClass_12_8_TasksDriver {
    public static void main(String[] args) {
        ArrayList<InClass_12_8_Task> myList = new ArrayList<>();
        myList.add(new InClass_12_8_Task("Paint Bedroom", 2));
        myList.add(new InClass_12_8_Task("Paint Livingroom", 5));
        myList.add(new InClass_12_8_Task("Sweep PAtio ", 2));
        myList.add(new InClass_12_8_Task("Paint Basement", 1));
        myList.add(new InClass_12_8_Task("Paint Kitchen", 4));
        int time = 8;
        Collections.sort(myList);
        showTheList(myList, 8);
        ArrayList<InClass_12_8_Task> toDoList = maxTasks(myList, 8);
        System.out.printf("\n ---------------");
        showTheList(toDoList, 8);
    }

    private static ArrayList<InClass_12_8_Task> maxTasks(ArrayList<InClass_12_8_Task> myList, int time) {
        int currentTime = 0;
        int numberOfTasks = 0;
        ArrayList<InClass_12_8_Task> toDoList = new ArrayList<>();
        for(InClass_12_8_Task t : myList) {
            currentTime += t.getTime();
            if(currentTime > time) {
                break;
            }
            toDoList.add(t);
        }
        return toDoList;
    }

    private static void showTheList(ArrayList<InClass_12_8_Task> myList, int i) {
        for( InClass_12_8_Task t : myList ) {
            System.out.printf("\nN:%s T:%s", t.gettName(), t.getTime());
        }
    }}
