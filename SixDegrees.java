/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        if (graph == null || graph.size() == 0) {
			return -1;
		}
		if(s.label == t.label) {
		    return 0;
		}
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
		queue.add(s);
		int degrees = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			int i = 0;
			degrees++;
			while(i < size) {
				UndirectedGraphNode head = queue.poll();
				set.add(head);
				for( UndirectedGraphNode node: head.neighbors) {
					if(node.label == t.label) {
						return degrees;
					}
					if(node.label != t.label && !set.contains(node)){
						queue.offer(node);
					}
				}
				i++;
			}
		}
		return -1;
    }
}
