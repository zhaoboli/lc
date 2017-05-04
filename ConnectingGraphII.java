/*
Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), an edge to connect node a and node b
2. query(a), Returns the number of connected component nodes which include node a.

Example
5 // n = 5
query(1) return 1
connect(1, 2)
query(1) return 2
connect(2, 4)
query(1) return 3
connect(1, 4)
query(1) return 3

*/

public class ConnectingGraph2 {

	int[] graph;
    public ConnectingGraph2(int n) {
        // initialize your data structure here.
		graph = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			graph[i] = i;
		}
    }
	
	int find(int n) {
		if (graph[n] == n) {
			return n;
		}
		return graph[n] = find(graph[n]);
	}

    public void connect(int a, int b) {
        // Write your code here
		if (find(a) != find(b)) {
			graph[find(a)] = graph[find(b)];
		}
    }
        
    public int query(int a) {
        // Write your code here
		int sum = 0;
		if (find(a) == a) {
			return 1;
		} 
		int connected = graph[a];
		for (int i = 0; i < graph.length; i++) {
			if (graph[i] == a || graph[i] == connected) {
				sum++;
			}
		}
		return sum;
    }
}