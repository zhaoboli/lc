/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
	 //UnionFind
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> result = new ArrayList();
        if (nodes == null || nodes.size() == 0) {
            return result;
        }
		
		father = new HashMap<Integer, Integer>();
        for (UndirectedGraphNode node: nodes) {
            int curr = node.label;
			if (!father.containsKey(curr)) {
				father.put(curr, curr);
			}
            for (UndirectedGraphNode neighbor: node.neighbors) {
				if (!father.containsKey(neighbor.label)) {
					father.put(neighbor.label, neighbor.label);
				}
                this.union(curr, neighbor.label);
            }
        }
        connected(result);
        return result;

    }
	
	private HashMap<Integer, Integer> father;
	
	public int find(int a) {
            if(father.get(a) == a) {
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
	
	private void connected(List<List<Integer>> result) {
            HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
			for(Integer i: father.keySet()) {
				int root = find(i);
				if (map.containsKey(root)) {
					map.get(root).add(i);
					continue;
				}
				List<Integer> set = new ArrayList<Integer>();
				set.add(i);
				map.put(root, set);
			}
			for(List<Integer> li: map.values()) {
				Collections.sort(li);
				result.add(li);
			}
    }

	//TODO BFS
}

