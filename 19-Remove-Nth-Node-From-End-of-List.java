/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int index = removeNthNode(head, n);
        if (index == n){
            return head.next;
        }
        return head;
    }

    public int removeNthNode(ListNode node, int n){
        //returns the index of a node from the end side
        if (node.next == null){
            return 1;
        }

        int currIndex = 1+removeNthNode(node.next, n);
        if (currIndex == n+1){
            node.next = node.next.next;
        }
        return currIndex;
    }
}