class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][3];
        for(int arr1[][]:dp){
              for(int arr[]:arr1){
                  Arrays.fill(arr,-1);
              }
        }
        return fun(prices,0,2,1,dp);
    }
    int fun(int[] prices,int n,int k,int buy,int[][][] dp){
        if(n==prices.length) return 0;
        if(k==0) return 0;
        if(dp[n][buy][k]!=-1) return dp[n][buy][k];
        if(buy==1){
            return dp[n][buy][k]=Math.max(fun(prices,n+1,k,0,dp)-prices[n],fun(prices,n+1,k,1,dp));
        }else{
             return dp[n][buy][k]=Math.max(fun(prices,n+1,k-1,1,dp)+prices[n],fun(prices,n+1,k,0,dp));
        }
    }
}