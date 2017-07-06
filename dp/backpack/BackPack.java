public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        boolean[][] f = new boolean[n+1][m+1];
        f[0][0] = true;

        for(int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i-1][j];
                //Note error made here, missed to include 0
                if (j >= A[i-1] && f[i-1][j - A[i-1]) {
                    f[i][j] = true;
                }
            }
        }

        for (int max = m; max >= 0; max--) {
            if(f[n][max]) {
                return max;
            }
        }
        return 0;
    }
}
