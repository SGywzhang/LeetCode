package ReverseLinkedListII;

import Nodes.ListNode;

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode mNode = head;
        ListNode nNode = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        for(int i = 1; i < m; i++){
            pre = mNode;
            mNode = mNode.next;
        }

        for(int i = 1; i < n; i++){
            nNode = nNode.next;
        }

        while(mNode != nNode){
            pre.next = mNode.next;
            mNode.next = nNode.next;
            nNode.next = mNode;
            mNode = pre.next;
        }
        return dummy.next;
    }
}
