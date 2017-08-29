/**
 * Prob: two-sum-data-structure-design No: 607
 * hashmap 很自然想到，然后要找一个存在一个的值，需要for一遍，自然联想到ArrayList,但用entryset也可以做
 */
public class TwoSum {
    Map<Integer, Integer> map = null;
    List<Integer> list = null;

    public TwoSum() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }
    //add the number to an internal data structure
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
            list.add(number);
        }
    }

    //Find if there exists any pair of numbers which sum is equal to the value
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            int remain = value - curr;
            if (curr == remain && map.get(curr) > 1) {
                return true;
            }
            if (curr != remain && map.containsKey(remain)) {
                return true;
            }
        }
        return false;
    }
    // Your TwoSum object will be instantiated and called as such:
    // Two twoSum = new TwoSum();
    // twoSum.add(number);
    // twoSum.find(value);
}
