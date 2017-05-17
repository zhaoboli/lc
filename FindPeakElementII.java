class Solution {
    /**
     * @param A: An integer matrix
     * @return: the index of the peadk
     */
    public List<Integer> findPeakII(int[][] A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length ==0) {
            return result;
        } 
        int startR = 0;
        int endR = A.length - 1;
        while ( startR + 1 < endR) {
            int midR = startR + (endR - startR) / 2;
            int peakCol = findRowPeak(A, midR);
            if (matrix[midR][peakCol] > matrix[midR - 1][peakCol] && matrix[midR][peakCol] > matrix[midR + 1][peakCol]) {
                result.addAll({midR, peakCol}); 
            } else if (matrix[midR][peakCol] < matrix[midR-1][peakCol]) {
                endR = midR;
            } else {matrix[midR][peakCol] < matrix[midR+1][peakCol]) {
                startR = midR;
            }
        }
        int startPeak = findRowPeak(A, start);
        if (matrix[start][startPeak] > matrix[end][startPeak]) {
            result.addAll({start, startPeak}); 
        } 
        int endPeak = findRowPeak(A, end);
        if (matrix[end][endPeak] > matrix[start][endPeak]) {
            result.addAll({end, endPeak});
        }
        return result;
        }

    private int findRowPeak(int[][] matrix, int row) {
        int start = 0;
        int end = matrix[row].length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] > matrix[row][mid - 1] && matrix[row][mid] < matrix[row][mid + 1]) {
                start = mid;
            } else if (matrix[row][mid] < matrix[row][mid - 1] && matrix[row][mid] > matrix[row][mid + 1]) {
                end = mid;
            } else {
                return mid;
            }
        }
        
        if (matrix[row][start] > matrix[row][end]) {
            return start;
        }
        if (matrix[row][start] < matrix[row][end]) {
            return end;
        }
        
        return 0;
    }


