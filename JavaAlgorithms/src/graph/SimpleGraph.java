package graph;

import collections.MyHash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Ordered Graph without weight
 * @param <N>
 */
public class SimpleGraph<N> {

    private final MyHash<N,List<N>> graph = new MyHash<>(10);

    public SimpleGraph(){

    }

    public void insert(N node, List<N> neighbors) {
        graph.insert(node, neighbors);
    }

    public void remove(N node) {
        graph.remove(node);
    }

    public List<N> getNeighbors(N node){
        return graph.get(node);
    }

    public List<N> findPath(N str, N end) {
        List<N> path = findPath(str, end, new ArrayList<>(), new ArrayList<>());
        return path == null || !path.get(path.size() - 1).equals(end) ? Collections.emptyList() : path;
    }

    private List<N> findPath(N current, N searching, List<N> searched, List<N> path) {
        if (current.equals(searching) ) {
            path.add(searching);
            return path;
        } else if (graph.get(current) == null || graph.get(current).isEmpty()) {
            return path;
        }

        searched.add(current);

        path.add(current);

        for (N neighbor : graph.get(current)) {
            if (!searched.contains(neighbor)) {
                List<N> potentialPath = findPath(neighbor, searching,searched,path);
                if (potentialPath != null && potentialPath.get(potentialPath.size() - 1).equals(searching)) {
                    return potentialPath;
                }
                path.remove(neighbor);
            }
        }

        return null;
    }

}
