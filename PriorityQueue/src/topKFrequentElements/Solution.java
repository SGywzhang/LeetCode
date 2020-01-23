package topKFrequentElements;

import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));

        for(int n : map.keySet()){
            heap.offer(n);
            if(heap.size() > k){
                heap.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!heap.isEmpty()){
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
