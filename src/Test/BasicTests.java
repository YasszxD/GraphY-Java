package Test;


import GraphY.Graph;
public class BasicTests {





    public static void main(String[] args) {
        Graph g1 = new Graph();
        /* Test if the graph is empty */
 /*       if(g1.isEmpty()) System.out.println("this graph is empty");
        // add a Node labeled A
        g1.addNode("A");
        if(!g1.isEmpty()) System.out.println("this graph is not empty");
        System.out.println(g1);
*/

        /*Test adding Nodes*/
        g1 = new Graph();
        g1.addNode("A");
        g1.addNode("B");
        g1.addNode("C");
        System.out.println(g1);
        g1.delNode("A");
        System.out.println(g1);




        /**/

    }
}
