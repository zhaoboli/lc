/**
 * Prob: graph-valid-tree No:178
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree
 * You can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 */

//union find
public class Solution {
	int[] father;
	//Union find
	public boolean validTree(int n, int[][] edges) {
		
		if (edges == null || edges.length != n - 1) {
			return false;
		}
		
		father = new int[n];
		for (int index = 0; index < father.length; index++) {
			father[index] = index;
		}
		for (int i = 0; i < edges.length; i++) {
			if (find(edges[i][0]) != find(edges[i][1])) {
				connect(edges[i][0], edges[i][1]);
			}
		}
		int init = find(0);
		for ( int ct = 1; ct < n; ct++) {
			if (find(ct) != init) {
			    return false;
			}
		}
		return true;
	}
	
	private int find(int a) {
		if (father[a] == a) {
			return a;
		}
		return father[a] = find(father[a]);
	}
	
	private void connect(int a, int b) {
		if (find(a) == find(b)) {
			return;
		}
		father[find(a)] = father[find(b)];
	}
}
//bfs
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges == null) {
            return false;
        }
        if (n - 1 != edges.length) {
            return false;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (!map.get(x).contains(y)) {
                map.get(x).add(y);
            }
            if (!map.get(y).contains(x)) {
                map.get(y).add(x);
            }         
        }
        Set<Integer> hash = new HashSet<Integer>();
        hash.add(0);
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            Integer head = queue.poll();
            Set<Integer> neighbors = map.get(head);
            for (Integer i : neighbors) {
                if (hash.contains(i)) {
                    continue;
                }
                hash.add(i);
                queue.offer(i);
            }
        }
        return hash.size() == n;
    }
}
