package ReverseNodesInKGroup;

import Nodes.ListNode;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        for(int i = 1; cur != null; i++){
            if(i % k == 0){
                pre = reverse(pre, cur);
                cur = pre.next;
            }
            else{
                cur = cur.next;
            }

        }
        return dummy.next;
    }

    ListNode reverse(ListNode pre, ListNode tail){
        ListNode cur = pre.next;
        ListNode res =  pre.next;
        while(cur != tail){
            pre.next = cur.next;
            cur.next = tail.next;
            tail.next = cur;
            cur = pre.next;
        }
        return res;
    }
}
