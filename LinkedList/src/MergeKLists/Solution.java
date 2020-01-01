package MergeKLists;

import Nodes.ListNode;

import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null) return null;

        ListNode head = new ListNode(0);
        ListNode cur = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2)-> o1.val - o2.val);

        for(ListNode list: lists){
            if(list != null){
                pq.add(list);
            }
        }

        while(!pq.isEmpty()){
            cur.next = pq.poll();
            cur = cur.next;
            if(cur.next != null){
                pq.add(cur.next);
            }
        }
        return head.next;
    }
}