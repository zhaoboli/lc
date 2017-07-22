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
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        if (graph == null) {
            return result;
        }
        
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neigh : node.neighbors) {
                if (!map.containsKey(neigh)) {
                    map.put(neigh, 1);
                } else {
                    map.put(neigh, map.get(neigh) + 1);
                }
            }
        }

        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode head = queue.poll();
            result.add(head);
            for (DirectedGraphNode node : head.neighbors) {
                map.put(node, map.get(node) - 1);
                if (map.get(node) == 0) {
                    queue.offer(node); 
                }
            }
        }
        return result;
    }
}
