class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][4];
        for(int arr[]:dp) Arrays.fill(arr,-1);
       return fun(prices,0,0,dp);
        
    }
    int fun(int[] prices,int ind,int trans,int[][] dp){
        if(ind==prices.length || trans==4) return 0;
        if(dp[ind][trans]!=-1) return dp[ind][trans];
        if(trans%2==0){
            return dp[ind][trans]=Math.max(fun(prices,ind+1,trans+1,dp)-prices[ind],fun(prices,ind+1,trans,dp));
        }else{
            return dp[ind][trans]=Math.max(fun(prices,ind+1,trans+1,dp)+prices[ind],fun(prices,ind+1,trans,dp));
        }
    }
   
}