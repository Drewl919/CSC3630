import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class InClass_12_6_Graph_Search {
    public static void main(String[] args) {
//        Graph g = createGraph();
        Graph g = createGraph2();
        g.showGraph();
//        g.showBFS(5);
        g.DFS_Stack(2);
    }

    private  static Graph createGraph2(){
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        g.addEdge(3, 1);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 5);


        g.addEdge(4, 3);
        g.addEdge(5, 3);
        return g;
    }

    private static Graph createGraph() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);

        g.addEdge(1, 2);

        g.addEdge(2, 0);
        g.addEdge(2, 3);

        g.addEdge(3, 3);
        return g;
    }

    static class Graph {
        private int nVert = 0;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        Graph(int v) {
            this.nVert = v;
            for(int i=0; i<nVert; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                adjList.add(row);
            }
        }
        public void addEdge(int v1, int v2) {
            adjList.get(v1).add(v2);
//            adjList.get(v2).add(v1);
        }
        public void showGraph() {
            for(int i=0; i<adjList.size(); i++) {
                System.out.printf("\n V:%s is connected to...", i);
                for(int j=0; j<adjList.get(i).size(); j++) {
                    System.out.printf("- %s", adjList.get(i).get(j));
                }
            }
        }
        public void showBFS (int startNode) {
            System.out.printf("\n------------BFS to follow------------");
            boolean visited[] = new boolean[nVert];
            Deque<Integer> queue = new LinkedList<>();
            queue.add(startNode);
            visited[startNode] = true;
            int currentNode;
            while (queue.size() != 0) {
                currentNode = queue.poll();
                System.out.printf("\n N:%s", currentNode);
                ArrayList<Integer> theConnected = adjList.get(currentNode);
                for(int item : theConnected) {
                    if(!visited[item]) {
                        visited[item] = true;
                        queue.add(item);
                    }
                }
            }
        }
        public void DFS_Stack(int startNode) {
            System.out.printf("\n------------DFS to follow------------");
            boolean visited[] = new boolean[nVert];
            Stack<Integer> stack = new Stack<>();
            stack.push(startNode);
            int currentItem;
            while(!stack.empty()) {
                currentItem = stack.pop();

                if(!visited[currentItem]){
                    System.out.printf("\n %s", currentItem);
                    visited[currentItem] = true;
                }
                for(int i=0; i<adjList.get(currentItem).size(); i++) {
                    int theItem = adjList.get(currentItem).get(i);
                    if(!visited[theItem]){
                        stack.push(theItem);
                    }
                }
            }
        }
    }
}
