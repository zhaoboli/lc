/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) { 
		if (nodes == null) {
			return null;
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
		for (DirectedGraphNode node: nodes) {
			set.add(node.label);
			for(DirectedGraphNode neigh: node.neighbors) {
				set.add(neigh.label);
			}
		}
		UnionFind uf = new UnionFind(set);
		for (DirectedGraphNode node: nodes) {
			int cur = node.label;
			for (DirectedGraphNode neigh: node.neighbors) {
				uf.union(cur, neigh.label);
			}
		}
		return uf.connected();
    }
	
	
	
	private class UnionFind {
		private HashMap<Integer, Integer> father;
		public UnionFind(HashSet<Integer> hash) {
		    father = new HashMap<Integer, Integer>();
			for (Integer i: hash) {
				father.put(i, i);
			}
		}
		
		public int find(int a) {
			if (father.get(a) == a) {
				return a;
			}
			father.put(a, find(father.get(a)));
			return father.get(a);
		}
		
		public void union(int a, int b) {
			int rootA = find(a);
			int rootB = find(b);
			if (rootA != rootB) {
				father.put(rootA, rootB);
			}
		}
		
		public List<List<Integer>> connected() {
			List<List<Integer>> result = new ArrayList();
			HashMap<Integer, List<Integer>> hash = new HashMap<Integer, List<Integer>>();
			
			for (Integer key: this.father.keySet()) {
				int root = this.find(key);
				if (!hash.containsKey(root)) {
					hash.put(root, new ArrayList<Integer>());
				}
				hash.get(root).add(key);
			}
			
			for (List<Integer> li: hash.values()) {
				Collections.sort(li);
				result.add(li);
			}
			return result;
		}	
	}
	
}