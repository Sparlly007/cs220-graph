package graph;
import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

public class BFS_DFSTest {
	
	static class OrderedNodeVisitor implements NodeVisitor{
        private ArrayList nodes = new ArrayList();
        public ArrayList<String> getOrder() {
            return nodes;
        }
        @Override
        public void visit(INode node) {
            nodes.add(node.getName());
        }
    }

	@Test
    public void testBFS() {
        /* Testing on the graph below. 
         * Plug into Graphviz at http://www.webgraphviz.com 
         * or https://dreampuf.github.io/GraphvizOnline/
graph bfs1 {
      A -- B
      A -- C
      A -- D
      D -- E
}
         */
        IGraph g = new Graph();
        INode f = g.getOrCreateNode("0");
		INode h = g.getOrCreateNode("1");
		INode i = g.getOrCreateNode("2");
		INode j = g.getOrCreateNode("3");
		INode k = g.getOrCreateNode("4");
		INode l = g.getOrCreateNode("5");
		INode m = g.getOrCreateNode("6");
		INode n = g.getOrCreateNode("2.5");
		f.addUndirectedEdgeToNode(h, 29); //0<->1
		f.addUndirectedEdgeToNode(i, 6); //0<->2
		h.addUndirectedEdgeToNode(i, 9); //1<->2
		i.addUndirectedEdgeToNode(j, 5); //2<->3
		i.addUndirectedEdgeToNode(n, 36); //2<->2.5
		h.addUndirectedEdgeToNode(k, 8); //1<->4
		j.addUndirectedEdgeToNode(l, 7); //3<->5
		k.addUndirectedEdgeToNode(m, 8); //4<->6
		j.addUndirectedEdgeToNode(n,  3); //3<->2.5
		
        OrderedNodeVisitor v = new OrderedNodeVisitor();
        g.breadthFirstSearch("0", v);
        ArrayList<String> order = v.getOrder();
        assertEquals("0", order.get(0));
        assertEquals("3", order.get(4));
        assertEquals("2", order.get(2));
        assertEquals("6", order.get(6));
    }
	
	@Test
	public void testDFS() {
		IGraph g = new Graph();
        INode f = g.getOrCreateNode("0");
		INode h = g.getOrCreateNode("1");
		INode i = g.getOrCreateNode("2");
		INode j = g.getOrCreateNode("3");
		INode k = g.getOrCreateNode("4");
		INode l = g.getOrCreateNode("5");
		INode m = g.getOrCreateNode("6");
		INode n = g.getOrCreateNode("2.5");
		f.addUndirectedEdgeToNode(h, 29); //0<->1
		f.addUndirectedEdgeToNode(i, 6); //0<->2
		h.addUndirectedEdgeToNode(i, 9); //1<->2
		i.addUndirectedEdgeToNode(j, 5); //2<->3
		i.addUndirectedEdgeToNode(n, 36); //2<->2.5
		h.addUndirectedEdgeToNode(k, 8); //1<->4
		j.addUndirectedEdgeToNode(l, 7); //3<->5
		k.addUndirectedEdgeToNode(m, 8); //4<->6
		j.addUndirectedEdgeToNode(n,  3); //3<->2.5
		
        OrderedNodeVisitor v = new OrderedNodeVisitor();
        g.depthFirstSearch("0", v);
        ArrayList<String> order = v.getOrder();
        assertEquals("0", order.get(0));
        assertEquals("1", order.get(1));
        assertEquals("4", order.get(2));
        assertEquals("2", order.get(4));
        assertEquals("3", order.get(5));
	}

}
