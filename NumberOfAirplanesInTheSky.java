/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
		if (airplanes == null || airplanes.size() == 0) {
			return 0;
		}
		List<Point> list = new ArrayList<Point>(airplanes.size() * 2);
		for (int i = 0; i < airplanes.size(); i++) {
			Point pStart = new Point(airplanes.get(i).start, 1);
			list.add(pStart);
			Point pEnd = new Point(airplanes.get(i).end, 0);
			list.add(pEnd);
		}
		Collections.sort(list, Point.PointComparator);
		int answer = 0;
		int counter = 0;
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).planeFlag == 1) {
				counter++;
			} else {
				counter--;
			}
			answer = Math.max(answer, counter);
		}
		return answer;
    }
	
	
	
}
class Point {
		public int time;
		public int planeFlag;
		
		public Point(int time, int flag) {
			this.time = time;
			this.planeFlag = flag;
		}
		
		public static Comparator<Point> PointComparator = new Comparator<Point>() {
		public int compare(Point p1, Point p2) {
			if (p1.time == p2.time) {
			    return p1.planeFlag - p2.planeFlag;
			} else {
			    return p1.time - p2.time;    
			}
		}
	    };

	}