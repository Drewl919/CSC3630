public class InClass_12_8_Task implements Comparable<InClass_12_8_Task>{
    private String tName;
    private int time;

    public InClass_12_8_Task(String tName, int time) {
        this.tName = tName;
        this.time = time;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(InClass_12_8_Task t) {
        if(this.time < t.time) return -1;
        else if (this.time > t.time) return 1;
        else return 0;
    }
}
