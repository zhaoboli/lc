/**
 * Prob: minimum-spanning-tree No: 629
 * Given a list of Connections, which is the Connection class 
 * (the city name at both ends of the edge and a cost between them), find some edges, connect all the cities and spend the least amount.
 * Return the connects if can connect all the cities, otherwise return empty list.
 * Return the connections sorted by the cost, or sorted city1 name if their cost is same, or sorted city2 if their city1 name is also same.
 * Example: Gievn the connections = ["Acity","Bcity",1], ["Acity","Ccity",2], ["Bcity","Ccity",3]
 * Return ["Acity","Bcity",1], ["Acity","Ccity",2]
 */
/**
 * Definition for a Connection.
 * public class Connection {
 *   public String city1, city2;
 *   public int cost;
 *   public Connection(String city1, String city2, int cost) {
 *       this.city1 = city1;
 *       this.city2 = city2;
 *       this.cost = cost;
 *   }
 * }
 */
public class Solution {
    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    public List<Connection> lowestCost(List<Connection> connections) {
        if (connections == null || connections.length == 0) {
            return new ArrayList<Connection>();
        }
        Collections.sort(connections, comp);    
        Map<Connection> map = new HashMap<Connection>();
        int index = 0;
        for (Connection conn : connections) {
            if (!map.containsKey(conn.city1)) {
                map.put(conn.city1, ++index);
            }
            if (!map.containsKey(conn.city2)) {
                map.put(conn.city2, ++index);
            }
        }
        int[] father = new int[index+1];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
        ArrayList<Connection> res = new ArrayList<Connection>();
        for (Connection conn : connections) {
            int c1 = map.get(conn.city1);
            int c2 = map.get(conn.city2);
            if (find(c1, father) == find(c2.father)) {
                continue;
            }     
            connect(c1, c2, father);
            res.add(conn);
        }
        if (result.size() != n - 1) {
            return new ArrayList<Connection>();
        }
        return res;
    }
    private int find(int index, int[] father) {
        if (father[index] == index){
            return index;
        }
        return father[index] = find(father[index], father);
    }

    private void connect(int i1, int i2, int[] father) {
        int root1 = find(i1);
        int root2 = find(i2);
        if (root1 = root2) {
            return;
        }
        father[root1] = father[root2];
    }

    static Comparator<Connection> comp = new Comparator<Connection>() {
        public int compare(Connection conn1, Connection conn2) {
            if (conn1.cost != conn2.cost) {
                return conn1.cost - conn2.cost;
            }
            if (conn1.city1.equals(conn2.city1)) {
                return conn1.city2.compareTo(conn2.city2);
            }
            return conn1.city1.compareTo(conn2.city1);
        }
    }

}
