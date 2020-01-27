package ReorderList;

import Nodes.ListNode;

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        second = reverse(second);

        ListNode p2 = second;
        ListNode p1 = head;

        while(p2 != null){
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            p2.next = temp1;
            p1 = temp1;
            p2 = temp2;
        }
    }

    public ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode temp = head;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = dummy.next;
            dummy.next = temp;
            temp = next;
        }
        return dummy.next;
    }
}