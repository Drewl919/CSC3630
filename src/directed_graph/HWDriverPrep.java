package directed_graph;
//Andrew Musielak
//CSC 3630

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HWDriverPrep {
    public static void main(String[] args) {
        HWGraph g = createGraph();
        printGraph(g);
        Set<String> keys = g.getKeys();
        String startCity = "Chicago";
        String layOver = getLayOverCity(keys, startCity);
        Vertex v = g.getThisVertex(startCity, layOver);
        System.out.printf("\nThe connections from Start:%s with layover N:%s are (%s):", startCity, v.label, v.weight);
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
        Set<String> cities = new HashSet<>();
        for(String city : keys) {
            if(!city.equals(startCity)) {
                cities.add(city);
            }
        }
        System.out.printf("\nSelect a layover city (");
        boolean comma = false;
        for (String city : cities) {
            if (comma) {
                System.out.printf(", %s", city);
            } else {
                System.out.printf("%s", city);
                comma = true;
            }
        }
        System.out.printf("} -> ");
        String layover;
        while (true) {
            layover = s.nextLine();
            if(!cities.contains(layover)) {
                System.out.printf("\n%s is not a valid input.", layover);
            } else if (layover.equalsIgnoreCase("Orlando") || layover.equalsIgnoreCase("Houston")) {
                System.out.printf("\n%s is not a valid layover city.", layover);
            } else {
                return layover;
            }
        }
    }

    private static void showConnections(HWGraph g, Vertex layOverVertex) {
        String layoverCityName = layOverVertex.label;
        int layoverCityWeight = layOverVertex.weight;
        for(Vertex connection : g.getConnections(layoverCityName)) {
            System.out.printf("\nName:%s   Distance:%s   Total Distance:%s", connection.label, connection.weight, layoverCityWeight+connection.weight);
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
