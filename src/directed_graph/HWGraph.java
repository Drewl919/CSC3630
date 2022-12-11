package directed_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HWGraph {
    public HashMap<String, ArrayList<Vertex>> graphMap = new HashMap<>();

    public void addVertex(String label) {
        ArrayList<Vertex> items = new ArrayList<>();
        graphMap.put(label, items);
    }

    public void removeVertex(String label) {

    }

    public void addEdge(String label1, Vertex v) {
        graphMap.get(label1).add(v);
//        graphMap.get(label2).add(label1);
    }

    ArrayList<Vertex> getConnections(String label) {
        return this.graphMap.get(label);
    }

    Set<String> getKeys() {
        Set<String> keys = graphMap.keySet();
        return keys;
    }

    Vertex getThisVertex(String startCity, String destCity) {
        ArrayList<Vertex> destCities = getConnections(startCity);
        for (Vertex v : destCities) {
            if (v.label.equalsIgnoreCase(destCity)) {
                System.out.printf("v:%s", v);
                return v;
            }
        }
        return null;
    }

}
