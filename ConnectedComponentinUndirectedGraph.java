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
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> result = new ArrayList();
        if (nodes == null || node.size() == 0) {
            return result;
        }
        int size = nodes.size(); 
        UnionFind uf = new UnionFind(size);

        for (UndirectedGraphNode node: nodes) {
            int curr = node.label;
            for (UndirectedGraphNode neighbor: node.neighbors) {
                uf.union(curr, neighbor.label);
            }
        }
        return uf.connected();

    }

    private class UnionFind {
        private int[] father;
        public UnionFind(int n) {
            father = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                father[i] = i;
            }
        }

        public int find(int a) {
            if(father[a] == a) {
                return a;
            }
            return father[a] = find(father[a]);
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                father[rootA] = rootB;
            }
        }

        public List<List<Integer>> connected() {
            List<List<Integer>> result = new ArrayList();
            HashMap<Integer, List<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
            for ( int i = 1; i < father.size(); i++) {
                int root = find(i); 
                if (map.containsKey(root) {
                    map.get(root).add(i);
                    continue;
                }
                List<Integer> set = new ArrayList<Integer>();
                set.add(i);
                map.put(root, set)
            }
            return result(map.values);
        }
    }
    }

