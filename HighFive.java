/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        if (results == null || results.length == 0) {
			return null;
		}
		
		Map<Integer, Queue<Integer>> map = new HashMap<Integer, Queue<Integer>>();
		for (int i = 0; i < results.length; i++) {
			int id = results[i].id;
			int score = results[i].score;
			if(map.containsKey(id)) {
				map.get(id).offer(score);
			} else {
				Queue q = new PriorityQueue<Integer>(5, new Comparator<Integer>() { 
				public int compare (Integer i1, Integer i2) {
					return -(i1 - i2);
				}});
				q.offer(score);
				map.put(id, q);
			}
		}
		
		Map<Integer, Double> res = new HashMap<Integer, Double>();
		for(Map.Entry<Integer, Queue<Integer>> entry: map.entrySet()) {
			int id = (int)entry.getKey();
			Queue<Integer> heap = (Queue<Integer>)entry.getValue();
			int counter = 0;
			double sum = 0;
			double average = 0;
			while (!heap.isEmpty() && counter < 5) {
				sum += (int)heap.poll();
				counter++;
			}
			average = sum / counter;
			res.put(id, average);
		}
		return res;
    }
}