/**
 * Prob: n-queens No: 33
 *The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *Given an integer n, return all distinct solutions to the n-queens puzzle.
 *Each solution contains a distinct board configuration of the n-queens' placement,
 *where 'Q' and '.' both indicate a queen and an empty space respectively.
 * [
 *   // Solution 1
 * [".Q..",
 *  "...Q",
 *  "Q...",
 *  "..Q."
 * ],
 * // Solution 2
 * ["..Q.",
 *  "Q...",
 *  "...Q",
 *  ".Q.."
 * ]
 * 
 *]
 * 思路：
 * 深搜，判定是不是能放下的点，1:当前列的前面已经有Q 2: 对角线上已经有Q, y - x = c; x + y  = c;
 *
 */
class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<Integer> path = new ArrayList<Integer>(); 
        helper(n, path, result);
        return result;
    }

    private void helper(int n, ArrayList<Integer> path, ArrayList<ArrayList<String>> result) {
        if (path.size() == n) {
            result.add(drawChessBoard(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(path, i)){
                continue;
            }
            path.add(i);
            helper(n, path, result);
            path.remove(path.size() - 1);
        }

    }

    private boolean isValid(ArrayList<Integer> path, int col) {
        int rowIndex = path.size();
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i) == col) {
                return false;
            }
            if (path.get(i) + i == col + path.size()) {
                return false;
            }
            if (path.get(i) - i == col - path.size()) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> drawChessBoard(ArrayList<Integer> path) {
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < path.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < path.size(); j++) {
                if (j == path.get(i)) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

};
