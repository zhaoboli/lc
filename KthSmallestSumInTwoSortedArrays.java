public class Solution {
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
     
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
		int[] dx = {1, 0};
		int[] dy = {0, 1};
		
		boolean[][] map = new boolean[A.length][B.length];
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>(k, new Comparator<Pair>() {
		   @Override 
		   public int compare(Pair p1, Pair p2) {
			    return p1.val - p2.val;
		    }
		});

		queue.offer(new Pair(0, 0, A[0] + B[0]));
		int i = 0;
		
		Pair head = null;
		while (i < k ) {
			head = queue.poll();
			i++;
			if (i == k) {
			    return head.val;
			}
			for (int j = 0; j < 2; j++) {
				int x = head.x + dx[j];
				int y = head.y + dy[j];
				if (x < A.length && y < B.length && !map[x][y]) {
					queue.offer(new Pair(x, y, A[x] + B[y]));
					map[x][y] = true;
				}
			}
		}
		return 0;
    }
    
    private class Pair { 
		public int x;
		public int y;
		public int val;
		public Pair(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
}