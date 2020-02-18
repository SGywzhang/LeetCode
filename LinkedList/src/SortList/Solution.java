package SortList;

import Nodes.ListNode;

import java.util.PriorityQueue;

class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode second = mid.next;
        mid.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(second);
        return merge(l, r);
    }

    ListNode merge(ListNode l, ListNode r){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l != null && r != null){

            if(l.val <= r.val){
                cur.next = l;
                l = l.next;
            }
            else{
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        if(l != null){
            cur.next = l;
        }

        if(r != null){
            cur.next = r;
        }
        return dummy.next;
    }

    ListNode getMid(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}