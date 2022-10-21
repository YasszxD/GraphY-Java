package GraphY;

import org.junit.jupiter.api.Test;

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
        assertFalse(g1.hasEdge("A","C",5f));
        g1.addEdge("A","B",3.8f);
        assertTrue(g1.hasEdge("A","B",3.8f));

        System.out.println("success");
    }


    @Test
    void testHasEdge() {
        g1.addNode("A");
        g1.addNode("B");
        assertFalse(g1.hasEdge("A","C"));
        g1.addEdge("A","B",3.8f);
        assertTrue(g1.hasEdge("A","B"));

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
    void maxHasEdge() { /*RETURN MAX*/
        g1.addNode("A");
        g1.addNode("B");
        assertEquals(g1.INF,g1.maxHasEdge("A","B"));
        g1.addEdge("A","B",3.8f);
        g1.addEdge("A","B",5f);
        assertEquals(5f,g1.maxHasEdge("A","B"));
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
    void delNode() {
        g1.addNode("A");
        System.out.println(g1);
        assertTrue(g1.delNode("A"));
        assertFalse(g1.hasNode("A"));

        assertFalse(g1.hasNode("A"));


        System.out.println("success");
    }

    @org.junit.jupiter.api.Test
    void delEdge() {
        g1.addNode("A");
        g1.addNode("B");
        g1.addEdge("A","B",5f);
        g1.addEdge("A","B",3f);
        assertTrue(g1.delEdge("A", "B"));
        assertFalse(g1.hasEdge("A","B",5f));
        assertFalse(g1.hasEdge("A","B",3f));

        System.out.println("success");
    }

    @Test
    void testDelEdge() {
        g1.addNode("A");
        g1.addNode("B");
        g1.addEdge("A","B",5f);
        g1.addEdge("A","B",3f);
        assertTrue(g1.delEdge("A", "B",5f));
        assertFalse(g1.hasEdge("A","B",5f));
        assertTrue(g1.hasEdge("A","B",3f));


        System.out.println("success");

    }


    @org.junit.jupiter.api.Test
    void graphOrder() {
        assertEquals(0,g1.graphOrder());
        g1.addNode("A");
        assertEquals(1,g1.graphOrder());

        System.out.println("success");

    }

    @org.junit.jupiter.api.Test
    void getEdgeNumber() {
        assertEquals(0,g1.getEdgeNumber());
        g1.addNode("A");
        g1.addNode("B");
        g1.addEdge("A","B",5F);
        assertEquals(1,g1.getEdgeNumber());

        System.out.println("success");


    }

    @org.junit.jupiter.api.Test
    void exitOrder() { // WHEN THERE IS NO NODE RETURN -1
        //assertEquals(0,g1.exitOrder("A"));
        g1.addNode("A");
        assertEquals(0,g1.exitOrder("A"));
        g1.addNode("B");
        g1.addEdge("A","B",6F);
        assertEquals(1,g1.exitOrder("A"));
        assertEquals(0,g1.exitOrder("B"));
        System.out.println("success");
    }

    @org.junit.jupiter.api.Test
    void enterOrder() { // WHEN THERE IS NO NODE RETURN -1
        //assertEquals(0,g1.exitOrder("A"));
        g1.addNode("A");
        assertEquals(0,g1.exitOrder("A"));
        g1.addNode("B");
        g1.addEdge("A","B",6F);
        assertEquals(1,g1.enterOrder("B"));
        assertEquals(0,g1.enterOrder("A"));
        System.out.println("success");
    }

    @org.junit.jupiter.api.Test
    void isSimple() { //A graph with no loops and no parallel edges is called a simple graph.
        assertTrue(g1.isSimple());
        g1.addNode("A");
        g1.addNode("B");
        //DOUBLE LIASON
        g1.addEdge("A","B",1);
        g1.addEdge("A","B",1);
        assertFalse(g1.isSimple());
        g1.delEdge("A","B");
        assertFalse(g1.hasEdge("A","B"));
        //CYCLE
        g1.addEdge("A","A",1);
        assertFalse(g1.isSimple());

        System.out.println("success");

    }

    @org.junit.jupiter.api.Test
    void isComplete() {
        g1.addNode("A");
        g1.addNode("B");
        g1.addEdge("A","B",1);
        g1.addEdge("B","A",1);
        assertTrue(g1.isComplete());

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
    void adjacencyMatrix() { //tested image URL : https://imgur.com/a/aTGzf8L
        g1.addNode("A");
        g1.addNode("B");
        g1.addNode("C");
        g1.addNode("D");
        g1.addNode("E");
        assertArrayEquals(g1.createMatrix(5,5,0),g1.adjacencyMatrix());
        g1.addEdge("A","D",1);
        g1.addEdge("A","B",1);
        g1.addEdge("B","D",1);
        g1.addEdge("C","A",1);
        g1.addEdge("D","E",1);
        g1.addEdge("D","A",1);
        float[][] expected = {{0,1,0,1,0},
                            {0,0,0,1,0},
                            {1,0,0,0,0},
                            {1,0,0,0,1},
                            {0,0,0,0,0}};
        assertArrayEquals(expected,g1.adjacencyMatrix());
    }

    @org.junit.jupiter.api.Test
    void weightedAdjacencyMatrix() { //tested image URL : https://imgur.com/a/0UMONgi
        g1.addNode("A");
        g1.addNode("B");
        g1.addNode("C");
        g1.addNode("D");
        g1.addNode("E");

       assertArrayEquals(g1.createMatrix(5,5,0),g1.weightedAdjacencyMatrix());

        g1.addEdge("A","B",4);
        g1.addEdge("B","C",3);
        g1.addEdge("B","D",3);
        g1.addEdge("C","A",2);
        g1.addEdge("C","E",2);
        g1.addEdge("E","B",5);
        g1.addEdge("E","D",2);

        float[][] expected = {{0,4,0,0,0},
                            {0,0,3,3,0},
                            {2,0,0,0,2},
                            {0,0,0,0,0},
                            {0,5,0,2,0}};

        assertArrayEquals(expected,g1.weightedAdjacencyMatrix());


    }

    @org.junit.jupiter.api.Test
    void incidenceMatrix() { //tested image URL : https://imgur.com/a/ze75tKM
        g1.addNode("A");
        g1.addNode("B");
        g1.addNode("C");
        g1.addNode("D");

        assertArrayEquals(g1.createMatrix(4,4,0),g1.adjacencyMatrix());
        g1.addEdge("A","B",1);
        g1.addEdge("A","D",1);
        g1.addEdge("B","C",1);
        g1.addEdge("C","A",1);

        float[][] expected = {{1,1,0,-1},
                            {-1,0,1,0},
                            {0,-0,-1,1},
                            {0,-1,0,-0}};

        assertArrayEquals(expected,g1.incidenceMatrix());


    }

    @org.junit.jupiter.api.Test
    void indexNode() {
        g1.addNode("A");
        g1.addNode("C");
        g1.addNode("D");
        g1.addNode("B");
        assertEquals("B",g1.indexNode(1));
        assertEquals("D",g1.indexNode(3));
        assertEquals("A",g1.indexNode(0));
        assertEquals("C",g1.indexNode(2));
    }

    @org.junit.jupiter.api.Test
    void topologyOrder() { //image test URL : https://imgur.com/a/vDWLF68
        // NOT TREATED ERRORS ... return String[] {null...} instead 1 null
        g1.addNode("A");
        g1.addNode("C");
        g1.addNode("D");
        g1.addNode("B");
        g1.addNode("E");
        g1.addNode("F");
        g1.addNode("G");
        g1.addNode("H");


        g1.addEdge("H","G",1);

        g1.addEdge("H","F",1);
        g1.addEdge("G","E",1);
        g1.addEdge("G","D",1);
        g1.addEdge("F","E",1);
        g1.addEdge("F","C",1);
        g1.addEdge("C","B",1);
        g1.addEdge("D","B",1);
        g1.addEdge("B","A",1);

        assertArrayEquals(new String[]{"H", "F", "G", "C", "D", "E", "B", "A"},g1.topologyOrder());
        //THERE IS MORE THAN 1 SOLUTION , THIS IS ONE OF THEM

      /*  g1.addEdge("H","H",1F);
        //g1.addEdge("G","H",1);
        assertArrayEquals(new String[]{null,null,null,null,null,null,null,null},g1.topologyOrder());

        g1.delEdge("H","H",1F);// I THINK DIDN'T WORK
        */g1.addEdge("B","B",1F);

        assertArrayEquals(new String[]{"H", "F", "G", "C", "D", "E",null,null},g1.topologyOrder());




    }

    @org.junit.jupiter.api.Test
    void isCyclic() {
        // LOOPS IS NOT TREATED
        g1.addNode("A");
        g1.addNode("C");
        g1.addEdge("A","C",1F);
        assertFalse(g1.isCyclic());
        //g1.addEdge("C","A",1F);
        //g1.addEdge("A","A",1F);
        g1.addEdge("C","C",1F);
        assertTrue(g1.isCyclic());
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


    //test
}