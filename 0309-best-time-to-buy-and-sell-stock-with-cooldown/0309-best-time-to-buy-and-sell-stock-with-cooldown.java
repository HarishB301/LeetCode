class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return fun(prices,0,1,dp);
    }
    int fun(int[] prices,int ind,int buy,int[][] dp){
        if(ind>=prices.length) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        if(buy==1){
            return dp[ind][1]=Math.max(fun(prices,ind+1,0,dp)-prices[ind],fun(prices,ind+1,1,dp));
        }else{
            return dp[ind][0]=Math.max(fun(prices,ind+2,1,dp)+prices[ind],fun(prices,ind+1,0,dp));
        }
    }
    
}