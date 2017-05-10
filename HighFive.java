/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 * There are two properties in the node student id and scores, 
 * to ensure that each student will have at least 5 points, 
 * find the average of 5 highest scores for each person.
 * 
 * Given results = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]
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
	
	
	public Map<Integer, Double> highFiveTwo(Record[] results) {
        // Write your code here
        if (results == null || results.length == 0) {
			return null;
		}
		
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < results.length; i++) {
			int id = results[i].id;
			int score = results[i].score;
			if(map.containsKey(id)) {
				ArrayList<Integer> col = map.get(id);
				col.add(score);
				int index = col.size() - 1;
				while(index - 1 >= 0 && col.get(index) > col.get(index - 1)) {
					int temp = col.set(index, col.get(index - 1));
					col.set(index - 1, temp);
					index--;
				}
				if (col.size() > 5) {
					col.remove(col.size() - 1);
				}
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(score);
				map.put(id, list);
			}
		}
		
		Map<Integer, Double> res = new HashMap<Integer, Double>();
		for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()) {
			int id = (int)entry.getKey();
			ArrayList<Integer> list = (ArrayList<Integer>)entry.getValue();
			
			double sum = 0;
			double average = 0;
			int size = list.size();
			for ( int j = 0; j < size; j++) {
				sum += list.get(j);
			}
			average = sum / size;
			res.put(id, average);
		}
		return res;
    }
}