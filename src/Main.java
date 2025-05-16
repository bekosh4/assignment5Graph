import graph.*;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 2);
        graph.addEdge("A", "C", 4);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
        System.out.println("BFS: " + bfs.search(graph.getVertex("A")));

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
        System.out.println("Dijkstra: " + dijkstra.search(graph.getVertex("A")));
    }
}
