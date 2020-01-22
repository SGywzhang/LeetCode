package BestTimeToBuyAndSellStock;

class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int curPrice : prices){
            minPrice = Math.min(minPrice, curPrice);
            maxProfit = Math.max(maxProfit,curPrice - minPrice);
        }
        return maxProfit;
    }
}