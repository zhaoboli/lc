/**
 * Prob: graph-valid-tree No:178
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree
 * You can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 * 思路：
 * 如果是满足树条件的图，那么要满足edges = vertex - 1; and every vertex is connected
 * union find,那么1.连接完后判断所有点的father是否都为一个点 2.或者判断在连接前判断这两个点是否已经连接
 * bfs:同理edges = vertex - 1 必须满足
 * 把所有边遍历完成，放在Map<Vertex, Set<Neighbor>> 的一个map里，用bfs遍历这个map,统计新出现的点，放入一个set,如果是满足树条件的
 * 图，那么所有的点肯定会出现, set.size() == n;
 */

//union find 1.
public class Solution {
	int[] father;
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
public class Solution {

    public boolean validTree(int n, int[][] edges) {
        if (edges == null) {
            return false;
        }
        if (n - 1 != edges.length) {
            return false;
        }

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            if (uf.find(edges[i][0]) == uf.find(edges[i][1])) {
                return false;
            }
            uf.connect(edges[i][0], edges[i][1]);
        }
        return true;
    }

    private class UnionFind {

        private int[] father = null;

        public UnionFind(int n) {
            this.father = new int[n];
            for (int i = 0; i < n; i++) {
                this.father[i] = i;
            }
        }

        public void connect(int i1, int i2) {
            if (find(i1) == find(i2)) {
               return;
            } 
            father[find(i1)] = find(i2);
        }

        public int find(int i) {
            if (father[i] == i) {
                return i;
            }
            return father[i] = find(father[i]);
        }
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
