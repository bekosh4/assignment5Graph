package graph;

import java.util.*;

public class BreadthFirstSearch<V> {
    public List<V> search(Vertex<V> start) {
        List<V> visited = new ArrayList<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> seen = new HashSet<>();

        queue.add(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            visited.add(current.getData());

            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!seen.contains(neighbor)) {
                    queue.add(neighbor);
                    seen.add(neighbor);
                }
            }
        }
        return visited;
    }
}
