/**
 * Prob: insert-interval No: 30
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 * 思路：
 * 可以借鉴merge interval
 * 判断时要看要插入的元素是不是比前index下的元素的start小，如果小的话，在intervals的index之前插入这个元素
 *　接下来再走一遍merge intervals即可
 */


public class Solution {
    /*
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			result.add(newInterval);
			return result;
		}

		int index = 0;
		while (index < intervals.size() && intervals.get(index).start < newInterval.start) {
			index++;
		}
		//在给定的list中插入这个元素
		intervals.add(index, newInterval);
		
		result.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			Interval prev = result.get(result.size() - 1);
			Interval curr = intervals.get(i);
			if (curr.start <= prev.end) {
				prev.end = Math.max(curr.end, prev.end);
			} else {
				result.add(curr);
			}
		}
		return result;
    }
    
};