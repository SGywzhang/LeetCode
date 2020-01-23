package AddTwoNumberII;

import Nodes.ListNode;

import java.util.Stack;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1 != null){
            s1.push(p1.val);
            p1 = p1.next;
        }

        while(p2 != null){
            s2.push(p2.val);
            p2 = p2.next;
        }

        int carry = 0;
        ListNode dummy = new ListNode(-1);
        while(!s1.isEmpty() || !s2.isEmpty()){
            int num1 = 0;
            int num2 = 0;
            int sum = 0;
            if(!s1.isEmpty()){
                num1 = s1.pop();
            }

            if(!s2.isEmpty()){
                num2 = s2.pop();
            }

            sum = num1 + num2 + carry;
            ListNode temp = new ListNode(sum % 10);
            temp.next = dummy.next;
            dummy.next = temp;
            carry = sum / 10;
        }

        if(carry > 0){
            ListNode temp = new ListNode(carry);
            temp.next = dummy.next;
            dummy.next = temp;
        }

        return dummy.next;
    }
}
