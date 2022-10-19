package GraphY;

import static org.junit.jupiter.api.Assertions.*;

class GraphYTest {
    Graph g1;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        g1 = new Graph();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        g1 = null;
    }

    @org.junit.jupiter.api.Test
    void addNode() {
        System.out.println(g1);
        g1.addNode("A");
        System.out.println(g1);

    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(g1.isEmpty());
        g1.addNode("A");
        assertFalse(g1.isEmpty());
        System.out.println("success");

    }

    @org.junit.jupiter.api.Test
    void hasNode() {
        assertFalse(g1.hasNode("A"));
        g1.addNode("A");
        assertTrue(g1.hasNode("A"));
        assertFalse(g1.hasNode("B"));
        System.out.println("success");

    }

    @org.junit.jupiter.api.Test
    void hasEdge() {
        g1.addNode("A");
        g1.addNode("B");
        assertFalse(g1.hasEdge("A","C",5));
        g1.addEdge("A","B",3.8f);
        assertTrue(g1.hasEdge("A","B",3.8f));

        System.out.println("success");
    }

    @org.junit.jupiter.api.Test
    void addEdge() {
        g1.addNode("A");
        g1.addNode("B");
        assertFalse(g1.hasEdge("A","C",5));
        g1.addEdge("A","B",3.8f);
        assertTrue(g1.hasEdge("A","B",3.8f));

        System.out.println("success");

    }

    @org.junit.jupiter.api.Test
    void minHasEdge() { /*RETURN MAX NOT MIN*/
        g1.addNode("A");
        g1.addNode("B");
        assertEquals(g1.INF,g1.minHasEdge("A","B"));
        g1.addEdge("A","B",3.8f);
        g1.addEdge("A","B",5f);

        assertEquals(3.8f,g1.minHasEdge("A","B"));
        System.out.println("success");
    }

    @org.junit.jupiter.api.Test
    void numHasEdge() {
        assertEquals(0,g1.numHasEdge("A","B"));
        g1.addNode("A");
        g1.addNode("B");
        assertEquals(0,g1.numHasEdge("A","B"));
        g1.addEdge("A","B",3.8f);
        g1.addEdge("A","B",5f);
        assertEquals(2,g1.numHasEdge("A","B"));

        System.out.println("success");
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }

    @org.junit.jupiter.api.Test
    void delNode() { // CANT DELETE FIRST NODE
        assertFalse(g1.delNode("A"));
        g1.addNode("A");
        g1.addNode("B");
        assertTrue(g1.delNode("B"));
        assertFalse(g1.hasNode("B"));
        assertTrue(g1.hasNode("A"));
        assertTrue(g1.delNode("A"));


        System.out.println("success");
    }

    @org.junit.jupiter.api.Test
    void delEdge() { // no delete by weight value // delete all edges
        g1.addNode("A");
        g1.addNode("B");
        //assertEquals(false,g1.delEdge("A","B"));
        g1.addEdge("A","B",5f);
        g1.addEdge("A","B",3f);
        assertTrue(g1.delEdge("A", "B"));
        assertFalse(g1.hasEdge("A","B",5f));
        assertFalse(g1.hasEdge("A","B",3f));


        System.out.println("success");
    }



    @org.junit.jupiter.api.Test
    void graphOrder() {
    }

    @org.junit.jupiter.api.Test
    void getEdgeNumber() {
    }

    @org.junit.jupiter.api.Test
    void exitOrder() {
    }

    @org.junit.jupiter.api.Test
    void enterOrder() {
    }

    @org.junit.jupiter.api.Test
    void isSimple() {
    }

    @org.junit.jupiter.api.Test
    void isComplet() {
    }

    @org.junit.jupiter.api.Test
    void printMatrix() {
    }

    @org.junit.jupiter.api.Test
    void nodeClassment() {
    }

    @org.junit.jupiter.api.Test
    void createMatrix() {
    }

    @org.junit.jupiter.api.Test
    void adjacencyMatrix() {
    }

    @org.junit.jupiter.api.Test
    void weightedAdjacencyMatrix() {
    }

    @org.junit.jupiter.api.Test
    void incidenceMatrix() {
    }

    @org.junit.jupiter.api.Test
    void indexNode() {
    }

    @org.junit.jupiter.api.Test
    void topologyOrder() {
    }

    @org.junit.jupiter.api.Test
    void isCyclic() {
    }

    @org.junit.jupiter.api.Test
    void floydwarshall() {
    }

    @org.junit.jupiter.api.Test
    void floydwarshallpath() {
    }

    @org.junit.jupiter.api.Test
    void isConnex() {
    }

    @org.junit.jupiter.api.Test
    void graphDiameter() {
    }

    @org.junit.jupiter.api.Test
    void negativeCycle() {
    }

    @org.junit.jupiter.api.Test
    void distance() {
    }

    @org.junit.jupiter.api.Test
    void bellmanFord() {
    }
}