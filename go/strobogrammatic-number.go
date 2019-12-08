/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Write a function to determine if a number is strobogrammatic. The number is represented as a string.

Example 1:

Input:  "69"
Output: true

Example 2:

Input:  "88"
Output: true

Example 3:

Input:  "962"
Output: false
*/
package main

func isStrobogrammatic(num string) bool {
	nums := map[byte]byte{
		'6': '9',
		'8': '8',
		'9': '6',
		'0': '0',
		'1': '1',
	}
	i := 0
	j := len(num) -1
	for i <= j {
		r, ok := nums[num[i]]
		if !ok || r != num[j] {
			return false
		}
		i++
		j--
	}
	return true
}

