package directed_graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class HWDriverPrep {
    public static void main(String[] args) {
        HWGraph g = createGraph();
        printGraph(g);
        Set<String> keys = g.getKeys();
        System.out.printf("keys: %s", keys);
        String startCity = "Chicago";
        String layOver = getLayOverCity(keys, startCity);
        Vertex v = g.getThisVertex(startCity, layOver);
        System.out.printf("\n The connections from Start:%s with layover N:%s are (%s):", startCity, v.label, v.weight);
        showConnections(g, v);
    }

    private static void printGraph(HWGraph g) {
        Set<String> keys = g.getKeys();
        for (String key : keys) {
            System.out.printf("\n----Showing connections for key:%s----", key);
            for (Vertex connection : g.getConnections(key)) {
                System.out.printf("\nCity:%s  Dest:%s", connection.label, connection.weight);
            }
        }
    }

    private static String getLayOverCity(Set<String> keys, String startCity) {
        Scanner s = new Scanner(System.in);
        keys.remove(startCity);
        System.out.printf("\nSelect a layover city (");
        boolean comma = false;
        for (String key : keys) {
            if (comma) {
                System.out.printf(", %s", key);
            } else {
                System.out.printf("%s", key);
                comma = true;
            }
        }
        System.out.printf("} -> ");
        return s.next();
    }

    private static void showConnections(HWGraph g, Vertex layOverVertex) {
        // ToDo: Write this method
        // What: This method inputs the graph (g) and the layoverVertex.
        // Output: All of the cities connected to the layover vertex, their distance and total distance from Chicago
        // E.g.,
        // The connections from Start:Chicago with layover N:New York are (790):
        //      Name:Houston Distance:1647 Total Distance:2437
        //     Name:Orlando Distance:1080 Total Distance:1870
        int chicagoDist = 0;
        for (Vertex connection : g.getConnections(layOverVertex.label)) {
            if (connection.label.equals("Chicago")) {
                chicagoDist = connection.weight;
            }
        }
        for (Vertex connection : g.getConnections(layOverVertex.label)) {
            if (!connection.label.equals("Chicago") && !g.getConnections(connection.label).contains("Chicago")) {
                System.out.printf("\n  Name:%s Distance:%s Total Distance:%s", connection.label, connection.weight, connection.weight + chicagoDist);
            }
        }

    }

    private static HWGraph createGraph() {
        HWGraph g = new HWGraph();
        g.addVertex("Orlando");
        g.addVertex("Dallas");
        g.addVertex("Chicago");
        g.addVertex("Atlanta");
        g.addVertex("Houston");
        g.addVertex("New York");

        g.addEdge("Chicago", new Vertex("Dallas", 968));
        g.addEdge("Chicago", new Vertex("Atlanta", 718));
        g.addEdge("Chicago", new Vertex("New York", 790));

        g.addEdge("Dallas", new Vertex("Orlando", 1120));
        g.addEdge("Dallas", new Vertex("Houston", 239));

        g.addEdge("Atlanta", new Vertex("New York", 870));
        g.addEdge("Atlanta", new Vertex("Orlando", 438));
        g.addEdge("Atlanta", new Vertex("Dallas", 781));

        g.addEdge("Houston", new Vertex("Orlando", 1080));

        g.addEdge("New York", new Vertex("Orlando", 1080));
        g.addEdge("New York", new Vertex("Houston", 1647));
        return g;
    }
}
