/*
Find the first unique character in a given string. You can assume that there is at least one unique character in the string.
Example 1:
	Input: "abaccdeff"
	Output:  'b'

	Explanation:
	There is only one 'b' and it is the first one.


Example 2:
	Input: "aabccd"
	Output:  'b'

	Explanation:
	'b' is the first one.
*/
package main

func firstUniqChar(str string) byte {
	if len(str) == 0 {
		return '0'
	}

	res := make(map[byte]int, len(str))
	for i := 0; i < len(str); i++ {
		v := res[str[i]]
		res[str[i]] = v + 1
	}

	for i := 0; i < len(str); i++ {
		r := res[str[i]]
		if r == 1 {
			return str[i]
		}
	}

	return '0'
}
