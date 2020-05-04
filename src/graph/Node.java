package graph;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Node implements INode{
	private String name;
	private Map<INode, Integer>neighbors=new LinkedHashMap<>();
	
	public Node(String n) {
		this.name=n;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public ArrayList<INode> getNeighbors() {
		ArrayList<INode> keys = new ArrayList<INode>(neighbors.keySet());
		return keys;
	}
	
	public Map<INode, Integer>getNeighborMap(){
		return neighbors;
	}
	
	
	public void addDirectedEdgeToNode(INode neighbor, int weight) {
		neighbors.put(neighbor, weight);
		
	}
	
	public void addUndirectedEdgeToNode(INode neighbor, int weight) {
		neighbors.put(neighbor, weight);
		neighbor.getNeighborMap().put(this, weight);
	}
	
	@Override
	public void removeDirectedEdgeToNode(INode neighbor) {
		neighbors.remove(neighbor);
		
	}
	
	public void removeUndirectedEdgeToNode(INode neighbor) {
		neighbors.remove(neighbor);
		neighbor.getNeighborMap().remove(this);
		
	}
	
	public boolean hasEdge(INode node) {
		// TODO Auto-generated method stub
		if(neighbors.isEmpty() || !this.neighbors.containsKey(node))
			return false;
		return true;
	}
	

	public int getWeight(INode node) {
		if(this.hasEdge(node)==false)
			return 0;
		return neighbors.get(node);
	}
	
}
