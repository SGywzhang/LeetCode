package KthLargestElementInAnArray;

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>(nums.length,(num1, num2)-> num2 - num1);

        for(int num : nums){
            q.offer(num);
        }

        for(int i = 0; i < k -1; i++){
            q.poll();
        }
        return q.peek();
    }
}