package AddTwoNumbers;

import Nodes.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(0);
        ListNode temp = head;

        int carry = 0;

        while(p1 != null || p2 != null){

            int num1 = p1 == null? 0 : p1.val;
            int num2 = p2 == null? 0 : p2.val;

            int sum = num1 + num2 + carry;

            carry = sum/10;

            temp.next = new ListNode(sum % 10);

            temp = temp.next;

            if(p1 != null) p1 = p1.next;
            if(p2 != null) p2 = p2.next;
        }

        if(carry > 0){
            temp.next = new ListNode(carry);
        }

        return head.next;
    }
}
