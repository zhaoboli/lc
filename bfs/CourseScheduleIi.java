/**
 * Prob: course-schedule-ii No: 616
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 *
 * Example:
 * Given n = 2, prerequisites = [[1,0]]
 * Return [0,1]
 * Given n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
 * Return [0,1,2,3] or [0,2,1,3]
 * 思路：
　* 很容易想到宽搜，因为这里的数是连续的从0到n-1, 因此通过下标就可以定位，用数组和list就可以了
 */
public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
     public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }
        Map<Integer, List<Integer>> outMap = new HashMap<Integer, List<Integer>>();
        Map<Integer, Integer> indegreeMap = new HashMap<Integer, Integer>();
        for (int[] arr: prerequisites) {
            if (!indegreeMap.containsKey(arr[0])) {
                indegreeMap.put(arr[0], 0);
            }
            indegreeMap.put(arr[0], indegreeMap.get(arr[0]) + 1);
            if (!outMap.containsKey(arr[1])) {
                outMap.put(arr[1], new ArrayList<Integer>());
            }
            outMap.get(arr[1]).add(arr[0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] result = new int[numCourses];
        int index = 0;
        for (int i = 0; i < numCourses; i++) {
            if(!indegreeMap.containsKey(i)) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            result[index++] = num;
            if (outMap.get(num) == null) {
                continue;
            }
            for (Integer i : outMap.get(num)) {
                indegreeMap.put(i, indegreeMap.get(i) - 1);
                if (indegreeMap.get(i) == 0) {
                    queue.offer(i);
                }
            }
        }
        if (index == numCourses) {
            return result;
        } else {
            return new int[0];
        }

    }
}
//better version
public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] arr: prerequisites) {
            indegrees[arr[0]] += 1;
            edges.get(arr[1]).add(arr[0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int[] result = new int[numCourses];
        int currIndex = 0;
        while (!queue.isEmpty()) {
            Integer head = queue.poll();
            result[currIndex++] = head;
            for (Integer point: edges.get(head)) {
                indegrees[point] -= 1;
                if (indegrees[point] == 0) {
                    queue.offer(point);
                }
            }
        }
        if (currIndex == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}
