/**
 * Prob: clone-graph No: 137
 * 思路：　
 * 一遍bfs
 */
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
How we serialize an undirected graph:
Nodes are labeled uniquely.
We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.
The graph has a total of three nodes, and therefore contains three parts as separated by #.
First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:
   1
  / \
 /   \
0 --- 2
     / \
     \_/
return a deep copied graph
/**
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>(); 
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
        map.put(node, newnode);
        queue.offer(node); 

        //时间复杂度 O(m(边数)+n(点数))
        //空间复杂度 O(n),额外的老点和新点的map
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            UndirectedGraphNode newhead = map.get(head);
            for (UndirectedGraphNode neighbor: head.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                newhead.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
