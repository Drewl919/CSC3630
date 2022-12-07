import java.util.ArrayList;

public class InClass_12_1_Drive_HMGraph {
    public static void main(String[] args) {
        InClass_12_1_HMGraph g = createGraph();
        showConnections(g, "Mo");

    }

    private static void showConnections(InClass_12_1_HMGraph g, String node) {
        System.out.printf("\n The connections for N:%s are:", node);
        ArrayList<String> connections = g.getConnections(node);
        for(String c : connections) {
            System.out.printf("\n C:%s", c);
        }
    }

    private static InClass_12_1_HMGraph createGraph() {
        InClass_12_1_HMGraph g = new InClass_12_1_HMGraph();
        g.addVertex("Mo");
        g.addVertex("Larry");
        g.addVertex("Curly");
        g.addVertex("Shemp");

        // Add Connections
        g.addEdge("Larry", "Curly");
        g.addEdge("Larry", "Mo");
        g.addEdge("Curly", "Shemp");

        return g;
    }
}
