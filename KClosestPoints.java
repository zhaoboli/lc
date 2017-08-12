/**
 * Prob: k-closest-points No: 612
 * Definition for a point
 * class Point {
 *  int x;
 *  int y;
 *  Point() { x = 0; y = 0; }
 *  Point(int a, int b) { x = a; y = b;}
 *  }
 *  思路：
 *  很容易想到用堆
 */

public class Solution {
    /*@param points a list of points
     * @param origin a point
     * @param k an integer
     * return the k closest points
     */
    //注意这里要用global的对象，因为Comparator是个inner class
    private Point globalOrigin = null;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        if (points == null || points.length == 0) {
            return null;
        }
        globalOrigin = origin;
        PriorityQueue<Point> heap = new PriorityQueue<Point> (k, new Comparator<Point>() {
            @Override
            public int compare(Point left, Point right) {
                int leftDistance = getDistance(left, globalOrigin);
                int rightDistance = getDistance(right, globalOrigin);
                int diff = rightDistance - leftDistance;
                if (diff == 0) {
                    diff = right.x - left.x;
                }
                if (diff == 0) {
                    diff = right.y - left.y;
                }
                return diff;
            }
        });

        for (int i = 0; i < points.length; i++) {
            heap.offer(points[i]);
            if( i >= k) {
                heap.poll();
            }
        }
        Point[] res = new Point[k];
        int j = k;

        while (!heap.isEmpty()) {
            res[--j] = heap.poll();
        }

        return res;

    }

    public int getDistance(Point p, Point origin) {
        return (p.x - origin.x) * (p.x - origin.x) + (p.y - origin.y) * (p.y - origin.y);
    }

}
