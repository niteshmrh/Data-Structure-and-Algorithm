import java.util.ArrayList;

class AdjencyMatrix {
    ArrayList<GraphNode> nodeList = new ArrayList<>();
    int adjMat[][];

    public AdjencyMatrix(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjMat = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j) {
        adjMat[i][j] = 1;
        adjMat[j][i] = 1;
    }
    
    public void addDirectedEdge(int i, int j) {
        adjMat[i][j] = 1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j : adjMat[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}