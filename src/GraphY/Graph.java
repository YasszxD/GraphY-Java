package GraphY;

/**
 * The GraphY is a basic package that implements some
 * graph functions
 *
 * @author  Yassine Abdelhedi
 * @version 1.1
 * @since   19-10-2022
 */

public class Graph {
  public int edgeNumber;
  public int nodeNumber;
  public HeadNode head;
  public final int INF = 9999;
/*  GraphY.Graph(){
    head = new GraphY.HeadNode("");
  }*/
  public boolean isEmpty(){
    return head == null;
  }
  public boolean hasNode(String label){
    HeadNode temp = head;
    while (temp != null && !label.equals(temp.label))
      temp = temp.nextHeadNode;
    if(temp == null)
      return false;
    return true;
  }
  public boolean addNode(String label){
    if(this.hasNode(label) == true)
      return false;
    HeadNode newNode = new HeadNode(label);
    if(this.isEmpty() == true){//empty
      head = newNode;
    }
    else{//not empty
      if(label.compareTo(head.label) < 0){//replace first GraphY.Node
        newNode.nextHeadNode = head;
        head = newNode;
      }
      else {//sort the node
        HeadNode temp = head;
        while (temp.nextHeadNode != null && label.compareTo(temp.nextHeadNode.label)> 0)
          temp = temp.nextHeadNode;
        newNode.nextHeadNode = temp.nextHeadNode;
        temp.nextHeadNode = newNode;
      }
    }
    this.nodeNumber++;
    return true;
  }
  public boolean addEdge(String label_src, String label_dest, float weight){
    if(!(this.hasNode(label_src)&&this.hasNode(label_dest)))
      return false;
    HeadNode temp = head;
    while (!temp.label.equals(label_src))
      temp=temp.nextHeadNode;

    Node newNode = new Node(label_dest,weight);
    if(temp.nextNode == null){//empty
      temp.nextNode = newNode;
    }
    else{//not empty
      if((label_dest.compareTo(temp.nextNode.label) < 0)||(label_dest.compareTo(temp.nextNode.label) == 0 && weight >temp.nextNode.weight )) {//replace first GraphY.Node
        newNode.nextNode = temp.nextNode;
        temp.nextNode = newNode;
      }
      else {//sort the node
        Node temp1 = temp.nextNode;
        while (temp1.nextNode != null && ((label_dest.compareTo(temp1.nextNode.label) > 0)||
          (label_dest.compareTo(temp.nextNode.label) == 0 && weight > temp.nextNode.weight )))
            temp1 = temp1.nextNode;
        newNode.nextNode = temp1.nextNode;
        temp1.nextNode = newNode;
      }
    }
    return true;
  }



  public boolean hasEdge(String label_src, String label_dest){
    if(!(this.hasNode(label_src)&&this.hasNode(label_dest))) return false;
    HeadNode temp = head;
    while(!temp.label.equals(label_src))
      temp=temp.nextHeadNode;
    Node temp1 = temp.nextNode;
    while(temp1!=null){
      if(temp1.label.equals(label_dest))
        return true;
      temp1=temp1.nextNode;
    }
    return false;
  }


  public boolean hasEdge(String label_src, String label_dest,float weight){
    if(!(this.hasNode(label_src)&&this.hasNode(label_dest))) return false;
    HeadNode temp = head;
    while(!temp.label.equals(label_src))
      temp=temp.nextHeadNode;
    Node temp1 = temp.nextNode;
    while(temp1!=null){
      if(temp1.label.equals(label_dest) && temp1.weight==weight)
        return true;
      temp1=temp1.nextNode;
    }
    return false;
  }





  public float maxHasEdge(String label_src, String label_dest){
    if(!(this.hasNode(label_src)&&this.hasNode(label_dest))) return INF;

    HeadNode temp = head;
    while(!temp.label.equals(label_src))
      temp=temp.nextHeadNode;
    Node temp1 = temp.nextNode;
    while(temp1!=null){
      if(temp1.label.equals(label_dest))
        return temp1.weight;
      temp1=temp1.nextNode;
    }
    return INF;
  }

  // public float minHasEdge(String label_src, String label_dest)/*min*/{ /*NOT TESTED*/
    /*if(!(this.hasNode(label_src)&&this.hasNode(label_dest))) return INF;

    HeadNode temp = head;
    while(!temp.label.equals(label_src))
      temp=temp.nextHeadNode;
    Node temp1 = temp.nextNode;
    while(temp1!=null){
      if(temp1.label.equals(label_dest))
        return temp1.weight;
      temp1=temp1.nextNode;
    }
    return INF;
  }
  */
  public int numHasEdge(String label_src, String label_dest){
    if(!(this.hasNode(label_src)&&this.hasNode(label_dest))) return 0;
    HeadNode temp = head;
    int num = 0;
    while(!temp.label.equals(label_src))
      temp=temp.nextHeadNode;
    Node temp1 = temp.nextNode;
    while(temp1!=null){
      if(temp1.label.equals(label_dest))
        num++;
      temp1=temp1.nextNode;
    }
    return num;
  }
  public String toString(){
    String x = "";
    HeadNode temp = head;
    while (temp != null){
      x+=temp.label;
      Node temp1 = temp.nextNode;
      while (temp1 != null){
        x+=" ";
        x+= temp1.label;
        x+=" ";
        x+=temp1.weight;
        x+=" ";
        temp1=temp1.nextNode;
      }
      x+="\n";
      temp = temp.nextHeadNode;
    }
    return x;
  }
  public boolean delNode(String label){
    if(!this.hasNode(label))
      return false;
    if(head.label.equals(label)) {
      head = head.nextHeadNode;
      return true;
    }


    HeadNode temp= head;
    while(temp.nextHeadNode!=null  ){
      if(temp.nextHeadNode.label.equals(label))
        temp.nextHeadNode=temp.nextHeadNode.nextHeadNode;
      else{
        this.delEdge(temp.label,label);
        System.out.println(this.delEdge(temp.label,label));
        temp=temp.nextHeadNode;
      }
    }

    this.delEdge(temp.label,label);
    this.nodeNumber--;
    return true;
  }
  public boolean delEdge(String label_src, String label_dest){
    if(!this.hasNode(label_src))
      return false;
    HeadNode temp1 = head;
    while(temp1!=null && !temp1.label.equals(label_src))
      temp1=temp1.nextHeadNode;
    //first ones


    //the rest
    while(temp1.nextNode!=null && temp1.nextNode.label.equals(label_dest))
      temp1.nextNode=temp1.nextNode.nextNode;

    return true;
  }
  public boolean delEdge(String label_src, String label_dest,float weight){
    if(!this.hasNode(label_src))
      return false;
    HeadNode temp1 = head;
    while(temp1!=null && !temp1.label.equals(label_src))
      temp1=temp1.nextHeadNode;
    //first ones


    //the rest
    while(temp1.nextNode!=null && temp1.nextNode.label.equals(label_dest)&& temp1.nextNode.weight==weight)
      temp1.nextNode=temp1.nextNode.nextNode;

    return true;
  }

  public int graphOrder(){
    return nodeNumber;
  }
  public int getEdgeNumber(){
    if(this.isEmpty()) return 0;
    HeadNode temp = head;
    Node temp1;
    int num=0;
    while (temp!=null) {
      temp1 = temp.nextNode;
      while (temp1!=null) {
        num++;
        temp1 = temp1.nextNode;
      }
      temp = temp.nextHeadNode;
    }
    return num;
  }
  public int exitOrder(String label){
    if(!this.hasNode(label))
      return -1;
    int number=0;
    //src label
    HeadNode temp = head;
    while (!temp.label.equals(label))
      temp=temp.nextHeadNode;
    if(temp.nextNode == null){}
    else{
      Node temp1=temp.nextNode;
      while (temp1 != null) {
        number++;
        temp1=temp1.nextNode;
      }
    }
    return number;
  }
  public int enterOrder(String label){
    int number = 0;
    HeadNode temp = head;
    Node temp1;
    while (temp!=null) {
      temp1=temp.nextNode;
      while (temp1!=null) {
        if(temp1.label.equals(label))
          number++;
        temp1=temp1.nextNode;
      }
      temp=temp.nextHeadNode;
    }
    return number;
  }
  public boolean isSimple(){//pas de double laison et boucle
    if(this.isEmpty()) return true;
    HeadNode temp = head;
    Node temp1;
    while(temp != null){
      temp1=temp.nextNode;
      while (temp1!=null) {
        if(this.numHasEdge(temp.label,temp1.label)>1 ||
                temp1.label.equals(temp.label)) return false;

        temp1=temp1.nextNode;
      }
      temp=temp.nextHeadNode;
    }
    return true;
  }
  public boolean isComplete(){
    int num = this.graphOrder();
    return this.getEdgeNumber() == (num) * (num - 1);
  }//chaque 2 sommet sont reliee , nombre d aret = n(n-1)/2(non orinte) n*(n-1) oriente
  /*****************************/
  public void printMatrix(float[][] mat){
    // Loop through all rows
    for (int i = 0; i < mat.length; i++){
      // Loop through all elements of current row
      for (int j = 0; j < mat[i].length; j++)
        System.out.print(mat[i][j] + "\t\t");
      System.out.println();
    }
  }
  public int nodeClassment(String label){
    int num = 0;
    HeadNode temp = head;
    while (temp!=null && !temp.label.equals(label)) {
      num++;
      temp=temp.nextHeadNode;
    }
    return num;
  }
  public float[][] createMatrix(int length, int wide, float initialValue){
    float[][] mat = new float[length][wide];
    int i,j;
    for(i=0;i<length;i++)
      for(j=0;j<wide;j++)
        mat[i][j]=initialValue;
    return mat;
  }
  public float[][] adjacencyMatrix(){
    int ordre = graphOrder();
    float[][] adjMat = createMatrix(ordre, ordre,0); // manich mo9tane3 ... lezem INF KI MAFAMCH EDGE BINETHOOM
    HeadNode temp = head;
    Node temp1;
    int i,j;
    while (temp!=null) {
      i = nodeClassment(temp.label);
      //adjMat[i][i]=0;// DEL HETHA W INIT 0 SI GHALET
      temp1 = temp.nextNode;
      while (temp1!=null) {

        j = nodeClassment(temp1.label);
        adjMat[i][j]=1;
        temp1 = temp1.nextNode;
      }
      temp = temp.nextHeadNode;
    }
    return adjMat;
  }
  public float[][] weightedAdjacencyMatrix(){//MAX
    int ordre = graphOrder();
    float[][] adjMat = createMatrix(ordre, ordre,INF);//INF KHATER MAHOMCH CONNECTE ... TESTAKHDMO FL WARSHELL
    HeadNode temp = head;
    Node temp1;
    int i,j;
    while (temp!=null) {
      i = nodeClassment(temp.label);
      adjMat[i][i]= 0;
      temp1 = temp.nextNode;
      while (temp1!=null) {
        j = nodeClassment(temp1.label);
        adjMat[i][j]=temp1.weight;
        temp1 = temp1.nextNode;
      }
      temp = temp.nextHeadNode;
    }
    for (i = 0; i < ordre; i++)
      adjMat[i][i]=0;
    return adjMat;
  } // tekhdem ama lezem l add mnathma*/
  public float[][] incidenceMatrix(){// vctnums are ordered as the main order
    float[][] mat = createMatrix(this.graphOrder(),this.getEdgeNumber(),0);
    int vctNum=0,index;
    HeadNode temp = head;
    Node temp1;
    while (temp!=null) {
      temp1=temp.nextNode;
      index = this.nodeClassment(temp.label);  //0
      while (temp1!=null) {
        mat[index][vctNum]= 1;
        mat[this.nodeClassment(temp1.label)][vctNum] = -1;
        vctNum++;
        temp1=temp1.nextNode;
      }
      temp=temp.nextHeadNode;
    }
    //mat[1][2]=5;
    return mat;
  }
  public String indexNode(int index){
    if (index>=graphOrder()|| index<0) return "";
    HeadNode temp = head;
    while(index>0){
      temp = temp.nextHeadNode;
      index--;
    }
    return temp.label;
  }
  public String[] topologyOrder(){
    int num = this.graphOrder();
    String[] ret = new String[num];
    boolean[] added =  new boolean[num];
    //methode1
    float[][] mat = this.adjacencyMatrix();
    int k=0,i=0,j=0,flag=0;
    for (i = 0; i < num; i++)
      added[i]=false;
    i=0;
    boolean first=true;
    while (flag!=i || first) {
      first=false;
      for(j=0;j<num;j++){
        if (mat[j][i] == 1)
          break;
      }
      if(j==num && added[i]==false){
        added[i]=true;
        for(j=0;j<num;j++)
          mat[i][j] = 0;
        flag=i;
        ret[k]=this.indexNode(i);
        k+=1;
      }
      i++;
      if(i==num)
        i=0;

      }
    return ret;
  }
  public boolean isCyclic(){
    return this.topologyOrder()[this.graphOrder()-1] == null;
  }
  public Floyd floydwarshall(){
    int order = this.graphOrder();
    Floyd f1 = new Floyd();
    f1.distanceMatrix=this.weightedAdjacencyMatrix();
    //setup f1.pathMatrix
    f1.pathMatrix=createMatrix(order,order,0);
    int i=0, j=0, k;
    for (i=0; i < order; i++)
      for (j=0; j < order; j++)
        f1.pathMatrix[i][j]=j;

    for (k=0; k < order; k++) {
      for (j=0; j < order; j++) {
        for (i=0; i < order; i++) {



          if(f1.distanceMatrix[i][k]== this.INF || f1.distanceMatrix[k][j]==this.INF) continue;
          if(f1.distanceMatrix[i][k]+f1.distanceMatrix[k][j]<f1.distanceMatrix[i][j] ){

            f1.distanceMatrix[i][j]=f1.distanceMatrix[i][k]+f1.distanceMatrix[k][j];
            f1.pathMatrix[i][j]=k;
          }

          //fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff
          //negative cycle diagonal <0
          if(i==j&&f1.distanceMatrix[i][j]<0) return null;
        }

      }
    }
   // printMatrix(f1.distanceMatrix);
    return f1;
  }//poid negative ou positife no cycle negative oriente
  public String[] floydwarshallpath(String label_src, String label_dest){//ya93ad 0 0 0 ml lekhra : mochkla : done
    Floyd f1 = this.floydwarshall();
    int or = this.graphOrder();
    int[] ret = new int[or];
    ret[0]=this.nodeClassment(label_src);
    ret[1]=this.nodeClassment(label_dest);
    int i = 0,j=or-1,len=2;
    if(f1.pathMatrix[ret[i]][ret[i+1]]==INF) return null;
    do {
      //System.out.println(i);
      if(f1.pathMatrix[ret[i]][ret[i+1]]==ret[i]||f1.pathMatrix[ret[i]][ret[i+1]]==ret[i+1])
        i++;
      else{
        for(j=or-1;j>i+1;j--){
          ret[j]=ret[j-1];
        }
        ret[i+1]=(int)f1.pathMatrix[ret[i]][ret[i+1]];
        len++;
      }
    } while (ret[i] != this.nodeClassment(label_dest));
    //String
    String[] ret1=new String[len];
    for (i = 0; i < len; i++) {
      ret1[i]=this.indexNode(ret[i]);
    }
    return ret1;
  }
  public boolean isConnex(){
    Floyd f1 = this.floydwarshall();
    if(f1==null) return false;
    for (int i = 0; i < f1.distanceMatrix.length; i++)
      for (int j = 0; j < f1.distanceMatrix[i].length; j++)
        if(f1.distanceMatrix[i][j] == INF) return false;
    return true;
  }
  public float graphDiameter(){
    float max = 0 ;
    Floyd f1 = this.floydwarshall();
    if(f1==null) return 0;
    for (int i = 0; i < f1.distanceMatrix.length; i++)
      for (int j = 0; j < f1.distanceMatrix[i].length; j++)
        if(f1.distanceMatrix[i][j] != INF &&f1.distanceMatrix[i][j]>max) max=f1.distanceMatrix[i][j];

    return max;
  }
  public boolean negativeCycle(){
    Floyd f1 = this.floydwarshall();
    return f1==null;
  }
  public float distance(String label_src, String label_dest){
    Floyd f1 = this.floydwarshall();
    if(f1==null) return 0;
    return f1.distanceMatrix[this.nodeClassment(label_src)][this.nodeClassment(label_dest)];
  }
  public BellmanFord BellmanFord(String label_src){//negative positif oriente ou non
    if(this.hasNode(label_src)==false) return null;
    int or = this.graphOrder();
    BellmanFord d1 = new BellmanFord();
    d1.distance = new float[or];
    d1.path = new String[or];
    //setup
    int i=0;
    int indexTemp,indexTemp1;
    for (; i < or; i++) d1.distance[i]=INF;  d1.distance[this.nodeClassment(label_src)]=0;
    d1.path[0]=label_src;
      HeadNode temp = head;
      Node temp1;
    for(i=1;i<this.graphOrder();i++){
      temp = head;
      while(temp!=null){
        temp1=temp.nextNode;
        indexTemp=nodeClassment(temp.label);
        while (temp1!=null) {
          indexTemp1=nodeClassment(temp1.label);
          if (d1.distance[indexTemp1]>d1.distance[indexTemp]+temp1.weight) {
            d1.distance[indexTemp1]=d1.distance[indexTemp]+temp1.weight;
            d1.path[indexTemp1]=this.indexNode(indexTemp1);
          }
          temp1=temp1.nextNode;
        }
        temp=temp.nextHeadNode;
      }
    }
    /*negativeCycle*/
    temp = head;
    while(temp!=null){
      temp1=temp.nextNode;
      indexTemp=nodeClassment(temp.label);
      while (temp1!=null) {
        indexTemp1=nodeClassment(temp1.label);
        if (d1.distance[indexTemp1]>d1.distance[indexTemp]+temp1.weight) {
          return null;
        }
        temp1=temp1.nextNode;
      }
      temp=temp.nextHeadNode;
    }

    return d1;
  }
  /*****************************/
  //Trasitive closure
  //dijkestra
  //coloriage//welsh powell
  //pofondeur
  //largeur
  //ACM
}
