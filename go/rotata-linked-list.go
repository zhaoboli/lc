/*
61. Rotate List
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 */
package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
type ListNode struct {
	Val int
	Next *ListNode
}

func rotateRight(head *ListNode, k int) *ListNode {
	if k <= 0 || head == nil || head.Next == nil {
		return head
	}
	dummy := &ListNode{0, nil}
	dummy.Next = head

	ct := 1
	holders := make([]*ListNode, 0)
	holders = append(holders, head)

	for head.Next != nil {
		head = head.Next
		holders = append(holders, head)
		ct++
	}

	offset := k % ct
	if offset == 0 {
		return dummy.Next
	}

	holders[ct - offset - 1].Next = nil // new tail
	holders[ct-1].Next = holders[0] // connect previous tail to previous head
	return holders[ct - offset] // new head
}
