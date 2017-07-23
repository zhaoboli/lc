class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 and 2
     * retrun nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null) {
           return;
        } 
        int indexZero = 0;
        int indexTwo = nums.length - 1;
        int index = 0;
        //Note: <= not <
        while(index <= indexTwo) {
            if (nums[index] == 0) {
                swap(nums, indexZero, index);
                index++;
                indexZero++;
            } else if(nums[index] == 1) { 
                index++;
            } else {
                swap(nums, indexTwo, index);
                //Note: index stays same, as a recheck needs to be done on the number switched over
                indexTwo--; 
            }
        } }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    //sort-colors
}
