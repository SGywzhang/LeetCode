package BestTimeToBuyAndSellStockII;

import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i] < prices[i + 1]){
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
       String s = "AB";

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            res = (s.charAt(i) - 'A' + 1) + res*26;
            System.out.println(s.charAt(i));
        }
        System.out.println(res);
    }
}