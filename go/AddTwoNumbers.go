/*
You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.

Example
Example 1:

Input: 7->1->6->null, 5->9->2->null
Output: 2->1->9->null
Explanation: 617 + 295 = 912, 912 to list:  2->1->9->null
Example 2:

Input:  3->1->5->null, 5->9->2->null
Output: 8->0->8->null
Explanation: 513 + 295 = 808, 808 to list: 8->0->8->null
*/
package main

func addLists(l1 *ListNode, l2 *ListNode) *ListNode {
	var carry int
	dummy := new(ListNode)

	var head *ListNode
	head = dummy

	for l1 != nil || l2 != nil || carry > 0 {
		h := new(ListNode)
		h.Val += carry
		if l1 != nil {
			h.Val += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			h.Val += l2.Val
			l2 = l2.Next
		}
		carry = h.Val / 10
		h.Val = h.Val % 10
		head.Next = h
		head = h
	}
	return dummy.Next
}
