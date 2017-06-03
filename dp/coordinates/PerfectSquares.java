public class Solution {
    /**
     * @param n a positive integer
     * @return an integer
     */
    //接龙
    public int numSquares(int n) {
      int[] f = new int[n+1];

      for (int i = 0; i <= n; i++) {
          f[i] = Integer.MAX_VALUE;
      }

      f[0] = 1;
      for (int i = 1; i * i <=n ; i++) {
          f[i * i] = 1;
      }
      // if number j * j = n, then f[j] = 1
      // else f[j] = i1 * i1 + i2 * i2 + i3 * i3 + ...; here all i1 * i1 , i2 * i2, i3 * i3 must < n
      for (int i = 1; i <= n; i++) {
          for (int j = 1; j * j <= i; j++) {
              f[i] = Math.min(f[i], f[i - j * j] + 1);
          }
      }
      return f[n];
    }
}
