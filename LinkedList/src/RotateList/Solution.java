package RotateList;

import Nodes.ListNode;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }

        cur.next = head;

        for (int i = 1; i < len - k % len; i++) {
            head = head.next;
        }

        cur = head.next;
        head.next = null;

        return cur;

    }
}