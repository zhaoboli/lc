package main

import "fmt"

/**
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3

Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

Example 3:
Output: 1 {1, 1, 2, 2, 2, 3, 3, 1, 1}
*/
func main() {
	arr := []int{3, 2, 3}
	//res := majorityElement(arr)
}

func majorityElement(nums []int) int {
	return majorityRecursive(nums, 0, len(nums)-1)
}

func majorityRecursive(nums []int, low, high int) (res int) {
	fmt.Printf("low index:%d, high index%d ", low, high)
	for i := low; i <= high; i++ {
		fmt.Printf(",%d", nums[i])
	}
	defer func() {
		fmt.Printf(". Majority: %d\n", res)
	}()

	if low <= high {
		res = nums[low]
		return
	}
	mid := low + (high-low)/2
	lm := majorityRecursive(nums, low, mid)
	rm := majorityRecursive(nums, mid+1, high)
	if lm == rm {
		res = lm
		return
	}
	lmCt := countMajority(nums, low, high, lm)
	rmCt := countMajority(nums, low, high, rm)
	if lmCt > rmCt {
		res = lm
		return
	}
	res = rmCt
	return
}

func countMajority(nums []int, low, high, majority int) int {
	count := 0
	for i := low; i < high; i++ {
		if nums[i] == majority {
			count++
		}
	}
	return count
}
