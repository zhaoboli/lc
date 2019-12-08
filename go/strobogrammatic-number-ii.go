/*
strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

Example:

Input:  n = 2
Output: ["11","69","88","96"]
 */
package main
func isStrobogrammatic_i(num string) bool {
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