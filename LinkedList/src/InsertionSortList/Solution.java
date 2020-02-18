package InsertionSortList;

import Nodes.ListNode;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode pre = null;
        ListNode temp = null;
        ListNode cur = head;
        dummy.next = head;
        while(cur != null && cur.next != null){
            if(cur.val <= cur.next.val){
                cur = cur.next;
            }
            else{
                pre = dummy;
                temp = cur.next;
                cur.next = cur.next.next;
                while(pre.next != null && pre.next.val <= temp.val){
                    pre = pre.next;
                }
                temp.next = pre.next;
                pre.next = temp;
            }
        }
        return dummy.next;
    }
}
