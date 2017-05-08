/**
 *
 *Definition for a point.
 *class Point {
 *int x;
 *int y;
 *Point() { x = 0; y = 0; }
 *Point(int a, int b) { x = a; y = b; }
 *
 *}
 *
 */
public class Solution {
    /**
     *
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */

    private class UnionFind {
        private int count;
        private int size;
        private int[] father;

        public UnionFind(int size) {
            father = new int[size];
            for (int i = 0; i < size; i++) {
                father[i] = i;
            }
        }

        public int find(int a) {
           if (father[a] == a) {
               return a;
           }
           return father[a] = find(father[a]);
        }

        public void insert() {
            this.count++;
        }

        public void connect(int a, int b) {
            if (find(a) == find(b)) {
                return;
            }
            father[find(a)] = father[find(b)];
            this.count--;
        }

        public int query(){
            return this.count;
        }
    }

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> res = new ArrayList<Integer>();
        if (operators == null || operators.length == 0) {
            return res;
        }
        UnionFind uf = new UnionFind(m * n);            
        boolean[][] seaMap = new boolean[n][m];
        for (int i = 0; i < operators.length; i++) {
            Point p = operators[i];
            if (!seaMap[p.x][p.y]) {
                uf.insert();
            }
            seaMap[p.x][p.y] = true;
            if(p.x > 0 && seaMap[p.x - 1][p.y]) {
                uf.connect(m * p.x + p.y, m * (p.x - 1) + p.y);
            }
            if (p.x + 1 < n && seaMap[p.x + 1][p.y]) {
                uf.connect(m * p.x + p.y, m * (p.x + 1) + p.y);
            }
            if (p.y > 0 && seaMap[p.x][p.y -1]) {
                uf.connect(m* p.x + p.y, m * p.x + p.y - 1);
            }
            if (p.y + 1 < m && seaMap[p.x][p.y + 1]) {
                uf.connect(m* p.x + p.y, m * p.x + p.y + 1);
            }
            res.add(uf.query());
        }
        return res;
    }
}
