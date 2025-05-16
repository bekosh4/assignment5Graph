package graph;

import java.util.*;

public class DijkstraSearch<V> {
    public Map<Vertex<V>, Double> search(Vertex<V> source) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        PriorityQueue<Map.Entry<Vertex<V>, Double>> pq =
                new PriorityQueue<>(Map.Entry.comparingByValue());

        distances.put(source, 0.0);
        pq.add(new AbstractMap.SimpleEntry<>(source, 0.0));

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll().getKey();

            for (Map.Entry<Vertex<V>, Double> neighborEntry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = neighborEntry.getKey();
                double newDist = distances.get(current) + neighborEntry.getValue();

                if (!distances.containsKey(neighbor) || newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    pq.add(new AbstractMap.SimpleEntry<>(neighbor, newDist));
                }
            }
        }
        return distances;
    }
}
