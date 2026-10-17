class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp00,dp01,dp10,dp11;
        dp00=0;
        dp01=0;
        for(int i=n-1;i>=0;i--){
            dp11=Math.max(dp00-prices[i],dp01);
            dp10=Math.max(dp01+prices[i],dp00);
            dp00=dp10;
            dp01=dp11;        
        }
        return dp01;
    }
    
}