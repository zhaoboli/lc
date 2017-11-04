public class Solution {
	/** 
	* Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
	* Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.	
	*/

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