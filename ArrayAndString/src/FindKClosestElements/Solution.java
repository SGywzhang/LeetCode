package FindKClosestElements;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer>list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(list, (a, b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        list = list.subList(0, k);
        Collections.sort(list);
        return list;
    }
}
