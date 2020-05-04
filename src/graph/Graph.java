package graph;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Graph implements IGraph{
	private Map<String, INode> nodes=new HashMap<>();
	
	public INode getOrCreateNode(String name) {
		if(nodes.containsKey(name))
			return nodes.get(name);
		Node n = new Node(name);
		nodes.put(name, n);
		return n;
	}

	
	public boolean containsNode(String name) {
		if(nodes.containsKey(name))
			return true;
		return false;			
	}

	
	public ArrayList<INode> getAllNodes() {
		Collection<INode> list = nodes.values();
		ArrayList<INode> array = new ArrayList<INode>(list);
		return array;
	}
	
	public void printNodes() {
		Collection<INode> nodes = this.getAllNodes();
		for(INode n : nodes) {
			System.out.println(n.getName());
		}
	}

	
	public void breadthFirstSearch(String startNode, NodeVisitor v) {
		LinkedList<String> list =  new LinkedList<String>(); 
		ArrayList<INode> check = new ArrayList<INode>();
		list.add(startNode);
		check.add(this.getOrCreateNode(startNode));
		
		while(!list.isEmpty()) {
			String name = list.poll();
			INode node = this.getOrCreateNode(name);
			v.visit(node);
			
			for(INode iterate: node.getNeighbors()) {  
				INode n = iterate;
				if(!check.contains(n)) {
					check.add(n);
					list.add(n.getName());
				}
			}
		}
	}

	
	public void depthFirstSearch(String startNode, NodeVisitor v) {
		Stack<String> stack = new Stack<String>();
		ArrayList<INode> check = new ArrayList<INode>();
		check.add(this.getOrCreateNode(startNode));
		stack.push(startNode);
		
		while(!stack.isEmpty()) {
			String name = stack.pop();
			INode node = this.getOrCreateNode(name);
			v.visit(node);
			
			ArrayList<INode> list = node.getNeighbors();
			Collections.reverse(list);
			for(INode iterate: list) {
				INode n = iterate;
				if(!check.contains(n)) {
					check.add(n);
					stack.push(n.getName());
				}
			}
		}
	}
	

	public Map<String, Integer> dijkstra(String sourceNode) {
		Map<String, Integer> result = new HashMap<String, Integer>();		
		Queue<Path> dij = new PriorityQueue<>();
		
		dij.add(new Path(sourceNode, 0));
		
		while(result.size() < this.getAllNodes().size()) {
			Path nextpath = dij.poll();
			String node = nextpath.getNode();
			if(result.containsKey(node))
				continue;
			int cost = nextpath.getCost();
			result.put(node, cost);
			INode n = this.getOrCreateNode(node);
			for(INode o : n.getNeighbors()) 
				dij.add(new Path(o.getName(), cost + n.getWeight(o)));
		}
		return result;
	}


	public Graph primJarnik() {
		Graph graph = new Graph();
		ArrayList<String> check = new ArrayList<String>();
		Queue<Path2> prim = new PriorityQueue<>();
		ArrayList<INode> list = this.getAllNodes();
		INode a = list.get(new Random().nextInt(list.size()));
		
		for(INode o : a.getNeighbors()) 
			prim.add(new Path2(a.getName(), o.getName(), a.getWeight(o)));
		
		check.add(a.getName());
		
		while(graph.getAllNodes().size() < this.getAllNodes().size() && !prim.isEmpty()) {
			Path2 nextpath = prim.poll();
			String source = nextpath.getSource();
			String dest = nextpath.getDest();
			if(check.contains(dest)) {
				continue;
			}
			int weight = nextpath.getCost();
			INode destNode = graph.getOrCreateNode(dest);
			INode gNode = this.getOrCreateNode(dest);
			INode sourceNode = graph.getOrCreateNode(source);
			sourceNode.addUndirectedEdgeToNode(destNode, weight);
			check.add(dest);
			for(INode o : gNode.getNeighbors()) 
				prim.add(new Path2(dest, o.getName(), gNode.getWeight(o)));
		}
		
		
		
		return graph;
	}

}
