package SmallestStringWithSwaps;

import java.util.*;

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        unionFindSet u = new unionFindSet(s.length());
        for(List<Integer> pair : pairs){
            u.union(pair.get(0), pair.get(1));
        }

        char[] arr = s.toCharArray();
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int key = u.find(i);
            if(map.containsKey(key)){
                map.get(key).offer(arr[i]);
            }
            else{
                PriorityQueue<Character> q = new PriorityQueue<Character>();
                q.offer(arr[i]);
                map.put(key,q);
            }
        }
        for(int i = 0; i < arr.length; i++){
            int key = u.find(i);
            arr[i] = map.get(key).poll();
        }
        return String.valueOf(arr);

    }

    class unionFindSet{
        int[] element;
        int[] height;
        public unionFindSet(int n){
            element = new int[n];
            height = new int[n];
            Arrays.fill(element, -1);
            Arrays.fill(height, 1);
        }

        int find(int i){
            while(element[i] != -1){
                i = element[i];
            }
            return i;
        }

        void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if(rootX != rootY){
                if(height[rootX] > height[rootY]){
                    element[rootY] = rootX;
                }
                else if(height[rootX] < height[rootY]){
                    element[rootX] = rootY;
                }
                else{
                    element[rootX] = rootY;
                    height[rootY]++;
                }
            }
        }
    }
}
