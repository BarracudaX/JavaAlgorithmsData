package graph;

import collections.MyHash;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        MyHash<String, MyHash<String, Integer>> graph = new MyHash<>(10);

        MyHash<String, Integer> neighborsOfStart = new MyHash<>(10);
        neighborsOfStart.insert("a", 6);
        neighborsOfStart.insert("b", 2);

        MyHash<String, Integer> neighborsOfA = new MyHash<>(10);
        neighborsOfA.insert("fin", 1);

        MyHash<String, Integer> neighborsOfB = new MyHash<>(10);
        neighborsOfB.insert("a", 3);
        neighborsOfB.insert("fin", 5);

        MyHash<String, Integer> neighborsOfFin = new MyHash<>(10);

        graph.insert("start", neighborsOfStart);
        graph.insert("a", neighborsOfA);
        graph.insert("b", neighborsOfB);
        graph.insert("fin", neighborsOfFin);

        MyHash<String, Integer> costs = new MyHash<>(10);
        costs.insert("a", 6);
        costs.insert("b", 2);
        costs.insert("fin", Integer.MAX_VALUE);

        MyHash<String, String> parents = new MyHash<>(10);
        parents.insert("a", "start");
        parents.insert("b", "start");
        parents.insert("fin", "");

        List<String> processed = new ArrayList<>();

        String node = find_lowest_cost(costs, processed);

        while (node != null) {
            int cost = costs.get(node);

            MyHash<String, Integer> neighbors = graph.get(node);

            for (String neighbor : neighbors.getKeys()) {
                int new_cost = cost + neighbors.get(neighbor);
                if (costs.get(neighbor) == null || costs.get(neighbor).compareTo(new_cost) > 0) {
                    costs.remove(neighbor);
                    costs.insert(neighbor, new_cost);
                    parents.remove(neighbor);
                    parents.insert(neighbor, node);
                }
            }
            processed.add(node);
            node = find_lowest_cost(costs, processed);
        }

        String parent = parents.get("fin");

        while (parent != null) {
            System.out.println(parent);
            parent = parents.get(parent);
        }
    }

    private static String find_lowest_cost(MyHash<String, Integer> costs, List<String> processed) {
        String firstNotProcessedNode = null;

        for (String node : costs.getKeys()) {
            if (!processed.contains(node)) {
                firstNotProcessedNode = node;
                break;
            }
        }

        if (firstNotProcessedNode == null) {
            return null;
        }

        String min = firstNotProcessedNode;

        Integer minWeight = costs.get(firstNotProcessedNode);

        for (String node : costs.getKeys()) {
            if (!min.equals(node) && !processed.contains(node) && minWeight.compareTo(costs.get(node)) > 0) {
                min = node;
                minWeight = costs.get(node);
            }
        }

        return min;
    }


}
