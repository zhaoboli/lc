/*Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), add an edge to connect node a and node b. 2.query(a, b)`, check if two nodes are connected

Example
5 // n = 5
query(1, 2) return false
connect(1, 2)
query(1, 3) return false
connect(2, 4)
query(1, 4) return true
*/

public class ConnectingGraph { 

    private int[] graph;
    
    public ConnectingGraph(int n) {
        // initialize your data structure here.
		graph = new int[n + 1];
		for (int i = 1; i < n+1; i++) {
			graph[i] = i;
		}
    }
	
	public int find(int i) {
		if (graph[i] == i) {
			return i;
		}
		return graph[i] = find(graph[i]);
	}

    public void connect(int a, int b) {
        // Write your code here
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			graph[rootA] = rootB;
		}
    }
        
    public boolean  query(int a, int b) {
        // Write your code here
		return find(a) == find(b);
    }
}