class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] dp=new int[2];
        int[] dp1=new int[2];
        // for(int[] arr:dp) Arrays.fill(arr,-1);
        // return fun(prices,0,1,dp);

        dp[0]=0;
        dp[1]=0;
        for(int i=n-1;i>=0;i--){
            dp1[1]=Math.max(dp[0]-prices[i],dp[1]);
            dp1[0]=Math.max(dp[1]+prices[i],dp[0]);
            dp=Arrays.copyOf(dp1,n+1);         
        }
        return dp[1];
    }
    int fun(int[] prices,int ind,int buy,int[][] dp){
        if(ind==prices.length) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        if(buy==1){
            return dp[ind][buy]=Math.max(fun(prices,ind+1,0,dp)-prices[ind],fun(prices,ind+1,1,dp));
        }else{
            return dp[ind][buy]=Math.max(fun(prices,ind+1,1,dp)+prices[ind],fun(prices,ind+1,0,dp));
        }
    }
}