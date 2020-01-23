package FindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{
    public List<Integer> findDisappearedNumbers(int[] nums)
    {
        for(int i = 0; i < nums.length; i ++)
        {
            int index = Math.abs(nums[i]);
            nums[index - 1] = - Math.abs(nums[index - 1]);
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i ++)
        {
            if(nums[i] > 0)
                result.add(i + 1);
        }

        return result;
    }
}

