package ReverseLinkedList;
import Nodes.ListNode;

/**
 * Definition for singly-linked list.
 * public class Nodes.ListNode {
 *     int val;
 *     Nodes.ListNode next;
 *     Nodes.ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode reverseHead = new ListNode(0);
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;

        }
        return reverseHead.next;
    }
}