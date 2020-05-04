package graph;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

public class DijandPrimTest {
	Graph g = new Graph();
	
	INode f = g.getOrCreateNode("0");
	INode h = g.getOrCreateNode("1");
	INode i = g.getOrCreateNode("2");
	INode j = g.getOrCreateNode("3");
	INode k = g.getOrCreateNode("4");
	INode l = g.getOrCreateNode("5");
	INode m = g.getOrCreateNode("6");
	INode n = g.getOrCreateNode("2.5");
	
	
	
	@Test
	public void tesDijkstrat() {
		f.addUndirectedEdgeToNode(h, 29); //0<->1
		f.addUndirectedEdgeToNode(i, 6); //0<->2
		h.addUndirectedEdgeToNode(i, 9); //1<->2
		i.addUndirectedEdgeToNode(j, 5); //2<->3
		i.addUndirectedEdgeToNode(n, 36); //2<->2.5
		h.addUndirectedEdgeToNode(k, 8); //1<->4
		j.addUndirectedEdgeToNode(l, 7); //3<->5
		k.addUndirectedEdgeToNode(m, 8); //4<->6
		j.addUndirectedEdgeToNode(n,  3); //3<->2.5
		
		Map<String, Integer> shortPaths = g.dijkstra("0");
		assertEquals(8, shortPaths.size());
		assertEquals(0, (int)shortPaths.get("0"));
		assertEquals(15, (int)shortPaths.get("1"));
		assertEquals(6, (int)shortPaths.get("2"));
		assertEquals(11, (int)shortPaths.get("3"));
		assertEquals(23, (int)shortPaths.get("4"));
		assertEquals(18, (int)shortPaths.get("5"));
		assertEquals(31, (int)shortPaths.get("6"));
		assertEquals(14, (int)shortPaths.get("2.5"));
	}
	
	@Test
	public void testPrimJarnik() {
		f.addUndirectedEdgeToNode(h, 29); //0<->1
		f.addUndirectedEdgeToNode(i, 6); //0<->2
		h.addUndirectedEdgeToNode(i, 9); //1<->2
		i.addUndirectedEdgeToNode(j, 5); //2<->3
		i.addUndirectedEdgeToNode(n, 36); //2<->2.5
		h.addUndirectedEdgeToNode(k, 8); //1<->4
		j.addUndirectedEdgeToNode(l, 7); //3<->5
		k.addUndirectedEdgeToNode(m, 8); //4<->6
		j.addUndirectedEdgeToNode(n,  3); //3<->2.5
		
		IGraph g2 = g.primJarnik();
		INode f2 = g2.getOrCreateNode("0");
		INode h2 = g2.getOrCreateNode("1");
		INode i2 = g2.getOrCreateNode("2");
		INode j2 = g2.getOrCreateNode("3");
		INode k2 = g2.getOrCreateNode("4");
		INode l2 = g2.getOrCreateNode("5");
		INode m2 = g2.getOrCreateNode("6");
		INode n2 = g2.getOrCreateNode("2.5");
		
		assertTrue(f2.hasEdge(i2));
		assertEquals(6, f2.getWeight(i2));
		assertTrue(i2.hasEdge(j2));
		assertEquals(5, i2.getWeight(j2));
		assertTrue(f2.hasEdge(i2));
		assertEquals(6, f2.getWeight(i2));
		assertTrue(n2.hasEdge(j2));
		assertEquals(3, n2.getWeight(j2));
		assertTrue(f2.hasEdge(i2));
		assertEquals(6, f2.getWeight(i2));
		assertTrue(l2.hasEdge(j2));
		assertEquals(7, l2.getWeight(j2));
		assertFalse(n2.hasEdge(i2));
		assertTrue(f2.hasEdge(i2));
		assertEquals(6, f2.getWeight(i2));
		assertFalse(f2.hasEdge(h2));
		assertTrue(f2.hasEdge(i2));
		assertEquals(6, f2.getWeight(i2));
		assertTrue(i2.hasEdge(h2));
		assertEquals(9, i2.getWeight(h2));
		assertTrue(f2.hasEdge(i2));
		assertEquals(6, f2.getWeight(i2));
		assertTrue(h2.hasEdge(k2));
		assertEquals(8, h2.getWeight(k2));
		assertTrue(m2.hasEdge(k2));
		assertEquals(8, m2.getWeight(k2));
		
		
		
		
	}

}
