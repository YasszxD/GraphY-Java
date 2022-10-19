package GraphY;

public class Test {
  public static void main(String[] args) {
    Graph g1 = new Graph();
    //ml kbir ll s8ir?
    g1.addNode("A");
    g1.addNode("B");
    g1.addNode("C");
    g1.addNode("D");
    g1.addNode("E");
    g1.addEdge("A","B",10);
    g1.addEdge("A","C",3);
    g1.addEdge("B","C",1);
    g1.addEdge("B","D",2);
    g1.addEdge("C","D",8);
    g1.addEdge("C","B",4);
    g1.addEdge("C","E",2);
    g1.addEdge("D","E",7);
    g1.addEdge("E","D",9);
  //  g1.addEdge("Yousri","Yassine",6);

    //g1.addEdge("Yousri","Yasmine",8);
//    g1.addEdge("Yasmine","Yassine",18);
    System.out.println(g1);
    System.out.println(g1.getEdgeNumber());
    BellmanFord d1 = g1.BellmanFord("A");
    for(float f: d1.distance) {
      System.out.println(f);
    }
    System.out.println();
    for(String s: d1.path) {
      System.out.println(s);
    }
  //  g1.delEdge("Yassine","Yousri");
  //  g1.delEdge("Yasmine","Yousri");
  //  g1.delEdge("Yemen","Yousri");
//    System.out.println(g1.nodeClassment("Yasmine"));
//  g1.printMatrix(g1.weightedAdjacencyMatrix());
  //  System.out.println(g1.topologyOrder());
/*  System.out.println(g1.isCyclic());
  g1.printMatrix(g1.floydwarshall().distanceMatrix);
  System.out.println();
  g1.printMatrix(g1.floydwarshall().pathMatrix);
  String[] a = g1.floydwarshallpath("A","D");
  for(String l: a) {
    System.out.println(l);
  }
  System.out.println(g1.isConnex());
  System.out.println(g1.graphDiameter());
    /*g1.delNode("Yousri");
    System.out.println(g1.graphOrder());
    System.out.println();
    System.out.println(g1);
    System.out.println(g1.isSimple());
    System.out.println(g1.getEdgeNumber());
    */
  }
}
