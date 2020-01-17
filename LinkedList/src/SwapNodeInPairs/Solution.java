package SwapNodeInPairs;

import Nodes.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode pre = h;
        ListNode p1 = h.next;
        ListNode p2 = h.next.next;
        while(p1 != null &&  p2 != null){
            pre.next = p2;
            ListNode t = p2.next;
            p2.next = p1;
            pre = p1;
            p1.next = t;
            p1 = p1.next;

            if(t!=null){
                p2 = t.next;
            }
        }
        return h.next;
    }
}