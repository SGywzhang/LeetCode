package KthSmallestElementInASortedMatrix;

import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                heap.offer(matrix[i][j]);
                if(heap.size() > k){
                    heap.poll();
                }
            }
        }
        return heap.peek();
    }
}