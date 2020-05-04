package graph;

import java.util.ArrayList;
import java.util.Map;

public interface INode
{
    String getName();
    
    ArrayList<INode> getNeighbors();
    
    void addDirectedEdgeToNode(INode neighbor, int weight);
    
    void addUndirectedEdgeToNode(INode neighbor, int weight);
    
    void removeDirectedEdgeToNode(INode neighbor);
    
    void removeUndirectedEdgeToNode(INode neightbor);
    
    boolean hasEdge(INode node);
    
    int getWeight(INode node);

	Map<INode, Integer> getNeighborMap();
}
