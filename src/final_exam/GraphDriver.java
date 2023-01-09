package final_exam;


public class GraphDriver {
    public static void main(String[] args) {
        GraphWeightedFE g = new GraphWeightedFE();
        g.addNode("Chicago");
        g.addNode("Boston");
        g.addNode("Dallas");
        g.addNode("New York");
        g.addNode("Buffalo");

        g.addEdge("Chicago", "Boston", 100);

        g.addEdge("Boston", "Dallas", 200);

        g.addEdge("Dallas", "Chicago", 135);
        g.addEdge("Dallas", "Boston", 100);
        g.addEdge("Dallas", "New York", 200);

        g.addEdge("New York", "Buffalo", 100);
        g.addEdge("New York", "Boston", 400);

        System.out.printf("\n ----- Printing Graph ----------");
        g.printGraph();

        System.out.printf("\n ----- Testing Routes  ----------");
        String src = "New York";
        String dest = "Chicago";
        checkRoute(g, src, dest);

        src = "Buffalo";
        dest = "Boston";
        checkRoute(g, src, dest);

        src = "Boston";
        dest = "Buffalo";
        checkRoute(g, src, dest);
    }

    private static void checkRoute(GraphWeightedFE g, String src, String dest) {
        if (g.gotRoute(src, dest)) {
            System.out.printf("\nYes there is a route from %s to %s", src, dest);
        } else {
            System.out.printf("\n No route exists from %s to %s", src, dest);
        }
    }
}
