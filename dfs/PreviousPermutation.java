public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     * 考察数学和基本功更多
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        if (nums == null) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums.size() <= 1) {
            return nums;
        }

        int index = nums.size() - 1;
        int subIndex = -1;

        while (index > 0) {
            index--;
            if (nums.get(index) > nums.get(index+1)) {
                subIndex = index;
                break;
            }
        }

        if (subIndex == -1) {
            //reverse the whole list
            reverseList(nums, 0, nums.size() - 1);
            return nums;
        }
        
        //find the largest number on right of subIndex which is smaller than nums[subIndex]
        int targetIndex = subIndex + 1;
        for (int j = targetIndex; j < nums.size(); j++) {
            if (nums.get(j) < nums.get(subIndex)) {
                //note: here should be =, as when situation [2, 1, 1], it should subsituate the last occurring 1, then after reversing, 2 will be the first 
                if(nums.get(j) >= nums.get(targetIndex)) {
                    targetIndex = j;
                }
            } else {
                break;
            }
        } 

        int temp = nums.get(subIndex);
        nums.set(subIndex, nums.get(targetIndex));
        nums.set(targetIndex, temp);

        //reverse the list from subIndex + 1 to end;
        reverseList(nums, subIndex +1, nums.size() -1); 
        return nums;
    }

    private void reverseList(ArrayList<Integer> nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        while (left <= right) {
            int temp = nums.get(left);
            nums.set(left, nums.get(right));
            nums.set(right, temp);
            left++;
            right--;
        }
    }
}
