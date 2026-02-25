import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode(0, "A"));
        nodeList.add(new GraphNode(1, "B"));
        nodeList.add(new GraphNode(2, "C"));
        nodeList.add(new GraphNode(3, "D"));
        nodeList.add(new GraphNode(4, "E"));

        AdjencyMatrix adjMat = new AdjencyMatrix(nodeList);
        adjMat.addUndirectedEdge(0, 1);
        adjMat.addUndirectedEdge(0, 2);
        adjMat.addUndirectedEdge(0, 3);
        adjMat.addUndirectedEdge(1, 4);
        adjMat.addUndirectedEdge(2, 3);
        adjMat.addUndirectedEdge(3, 4);

        System.out.println(adjMat.toString());
    }   
}
