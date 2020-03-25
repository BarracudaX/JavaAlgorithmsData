package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleGraphTest {

    private SimpleGraph<Integer> graph = new SimpleGraph<>();

    @BeforeEach
    public void setUp(){
        graph.insert(1, Arrays.asList(2, 3, 4, 5));
        graph.insert(2, Arrays.asList(10));
        graph.insert(3, Arrays.asList(12,2));
        graph.insert(4, Arrays.asList(6));
        graph.insert(5, Arrays.asList(6));
        graph.insert(10, Arrays.asList(11));
        graph.insert(11, Arrays.asList(9));
        graph.insert(6, Arrays.asList(7));
        graph.insert(12, Arrays.asList(13));
        graph.insert(13, Arrays.asList(14));
        graph.insert(14, Arrays.asList(15));
        graph.insert(15, Arrays.asList(9));

    }

    @Test
    public void shouldFindPath(){

        System.out.println(graph.findPath(1,9));
        System.out.println(graph.findPath(4,7));
        System.out.println(graph.findPath(4,9));
        System.out.println(graph.findPath(3,9));
    }

    @Test
    public void shouldReturnAllTheNeighbors() {
        List<Integer> neighbors = graph.getNeighbors(1);
        assertEquals(4, neighbors.size());
        assertTrue(neighbors.contains(2));
        assertTrue(neighbors.contains(3));
        assertTrue(neighbors.contains(4));
        assertTrue(neighbors.contains(5));
    }

}