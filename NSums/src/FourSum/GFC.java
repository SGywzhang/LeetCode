package FourSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GFG
{
    static class pair
    {
        int first, second;
        public pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }

    static List<Integer> findFour(int arr[], int target)
    {
        List<Integer> res = new ArrayList<>();
        Map<Integer, pair> map = new HashMap<>();
        for (int i = 0; i < arr.length  - 1; i++)
            for (int j = i + 1; j < arr.length; j++)
                map.put(arr[i] + arr[j], new pair(i, j));

        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                int sum = arr[i] + arr[j];

                if (map.containsKey(target - sum))
                {
                    pair p = map.get(target - sum);
                    if (p.first != i && p.first != j &&
                            p.second != i && p.second != j)
                    {
                        res.add(arr[i]);
                        res.add(arr[j]);
                        res.add(arr[p.first]);
                        res.add(arr[p.second]);
                    }
                }
            }
        }
        return res;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = {10, 20, 30, 40, 1, 2};
        int n = arr.length;
        int X = 91;
        findFour(arr, X);
    }
}

// This code is contributed by Princi Singh
