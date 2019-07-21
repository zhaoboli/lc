/*
Description

Given a non-negative integer. You could choose to swap two digits of it.
Return the maximum valued number you could get.

The given number is the  range of [0, 10^8]

Example:
example 1:

Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

example 2:
Input: 9973
Output: 9973
Explanation: No swap.

*/
package main

func maximumSwap(num int) int {
	if num < 10 {
		return num
	}

	var nums []int
	var maxIdxes []int

	max := num % 10
	maxIdx := 0
	for i := 0; num > 0; num = num / 10 {
		curr := num % 10
		nums = append(nums, curr)

		if curr > max {
			max = curr
			maxIdx = i
		}
		maxIdxes = append(maxIdxes, maxIdx)
		i++
	}

	for j := len(maxIdxes) - 1; j > 0; j-- {
		mIdx := maxIdxes[j]
		if nums[mIdx] > nums[j] {
			nums[mIdx], nums[j] = nums[j], nums[mIdx]
			break
		}
	}

	res := 0
	for i := len(nums) - 1; i >= 0; i-- {
		res = res*10 + int(nums[i]-'0')
	}
	return res
}
