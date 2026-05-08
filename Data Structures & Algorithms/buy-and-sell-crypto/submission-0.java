class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = Integer.MIN_VALUE;

        for(int i = 0 ; i < n-1; i++){
            for(int j = i+1 ; j < n ;j++){
                int profit = prices[j] - prices[i];
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        if(maxProfit < 0){
            return 0;
        }else{
            return maxProfit;
        }
    }
}
