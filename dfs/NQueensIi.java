/**
 * Prob: n-queens-ii No:
 * Follow up for N-Queens problem.
 * Now instead outputting borad configurations, return the total number of distinct solutions
 * Example: For n=4, there are 2 distinct solutions.
 * 思路：
 * 不再详述，跟n-queens一样，去掉了打印出解的部分
 */
public class Solution {
    /*
     * @param n: The total number of queens.
     * @return: the total number of distince solutions.
     */
    public int totalNQueens(int n) {
        Result res = new Result(0);
        ArrayList<Integer> path = new ArrayList<Integer>();
        helper(n, path, res);
        return res.ct;
    }

    private void helper(int n, ArrayList<Integer> path, Result result) {
        if (path.size() == n) {
            result.ct += 1;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(path, i)) {
                continue;
            }
            path.add(i);
            helper(n, path, result);
            path.remove(path.size() - 1);
        }
    }
     
    private boolean isValid(ArrayList<Integer> path, int col) {
        int row = path.size();
        for (int i = 0; i < row; i++) {
            if (path.get(i) == col) {
                return false;
            }
            if (i + path.get(i) == row + col) {
                return false;
            }
            if (i - path.get(i) == row - col) {
                return false;
            }
        }
        return true;
    }

    private class Result {
        int ct;
        public Result(int ct) {
            this.ct = ct;
        }
    }
}
