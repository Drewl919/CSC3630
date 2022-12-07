import java.util.ArrayList;
import java.util.HashMap;

public class InClass_12_1_HMGraph {
    public HashMap<String, ArrayList<String>> graphMap = new HashMap<>();

    public void addVertex(String label) {
        ArrayList<String> items = new ArrayList<>();
        graphMap.put(label, items);
    }

    public void removeVertex(String label){

    }
    public void addEdge(String label1, String label2) {
        graphMap.get(label1).add(label2);
        graphMap.get(label2).add(label1);
    }
    ArrayList<String> getConnections(String label) {
        return graphMap.get(label);
    }
}
