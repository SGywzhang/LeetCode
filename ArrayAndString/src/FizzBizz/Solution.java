package FizzBizz;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) return res;

        String s1 = "Fizz";
        String s2 = "Buzz";
        String s3 = "FizzBuzz";

        for(int i = 1; i <= n; i++){

            if(i % 3 == 0 && i % 5 == 0){
                res.add(s3);
            }

            else if(i % 3 == 0){
                res.add(s1);
            }
            else if(i % 5 == 0){
                res.add(s2);
            }
            else{
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
