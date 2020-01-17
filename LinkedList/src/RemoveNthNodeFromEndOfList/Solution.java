package RemoveNthNodeFromEndOfList;

import Nodes.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode first = head;
        int length = 0;
        while(first != null){
            first = first.next;
            length++;
        }
        length -= n;
        first = dummyNode;
        while(length > 0){
            first = first.next;
            length--;
        }
        first.next = first.next.next;
        return dummyNode.next;
    }
}