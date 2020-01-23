package MinimumIndexSumOfTwoLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }

        for (int i = 0; i < list1.length; i++) {
            if (map2.containsKey(list1[i])) {

                if (map1.get(list1[i]) + map2.get(list1[i]) < min) {
                    min = map1.get(list1[i]) + map2.get(list1[i]);
                    res = new ArrayList<>();
                    res.add(list1[i]);
                } else if (map1.get(list1[i]) + map2.get(list1[i]) == min)
                    res.add(list1[i]);
            }

        }
        return res.toArray(new String[res.size()]);
    }
}