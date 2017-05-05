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
		//May get over-time error
        for (int i = 1; i < graph.length; i++) {
            if (find(i) == find(a)) {
                sum++;
            }
        }
        return sum;
    }
}