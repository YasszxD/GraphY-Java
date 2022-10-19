package GraphY;

public class Node {
  public float weight;
  public  String label;
  public  Node nextNode;
  Node(String label, float weight){
    this.label=label;
    this.weight=weight;
  }
}
