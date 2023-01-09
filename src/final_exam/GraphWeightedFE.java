package final_exam;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphWeightedFE {
    HashMap<String, ArrayList<Node>> graph = new HashMap<>();

    public boolean addNode(String nName) {
        if (!graph.containsKey(nName)) {
            ArrayList<Node> items = new ArrayList<>();
            graph.put(nName, items);
            return true;
        }
        return false;
    }

    public boolean addEdge(String source, String destName, int weight) {
        Node destNode = new Node(destName, weight);
        if (graph.containsKey(destName)) {
            graph.get(source).add(destNode);
            return true;
        }
        return false;
    }

    public void printGraph() {
        for (String v : graph.keySet()) {
            System.out.printf("\nVertex:%s", v);
            for (Node n : graph.get(v)) {
                System.out.printf("\n ---Node:%s Distance:%s", n.Name, n.weight);
            }
        }
    }

    public boolean gotRoute(String startCity, String endCity) {
        boolean routeExists = false;
        HashMap<String, ArrayList<Node>> currentGraph = graph;
        for(Node n : currentGraph.get(startCity)) {
            if(n.Name.equalsIgnoreCase(endCity)) {
                routeExists = true;
            } else {
                for (Node n2: graph.get(n.Name)) {
                    if(n2.Name.equalsIgnoreCase(endCity)) {
                        routeExists = true;
                    } else {
                        for (Node n3: graph.get(n2.Name)) {
                            if(n3.Name.equalsIgnoreCase(endCity)) {
                                routeExists = true;
                            } else {
                                for (Node n4: graph.get(n3.Name)) {
                                    if(n4.Name.equalsIgnoreCase(endCity)) {
                                        routeExists = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return routeExists;
    }
}

class Node {
    String Name;
    int weight;

    public Node(String name, int weight) {
        this.Name = name;
        this.weight = weight;
    }
}