public class Solution {
    /**
     * @param A: A string includes Upper Case letters
     * @param B: A string inclues Upper case Letter
     * @return: if string A contains all of characters in B return true else return false
     */

    public boolean compareStrings(String A, String B) {
        if (A == null || B == null) {
            return false;
        }

        int[] map = new int[256];
        
        int n = A.length();
        int m = B.length();

        for (int i = 0; i < n; i++) {
            map[A.charAt(i)] += 1;
        }

        for (int j = 0; j < m; j++) {
            map[B.charAt(j)] -= 1;
            if (map[B.charAt(j)] < 0) {
                return false;
            }
        }
        return true;
    }
}
