class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return fun(n-1,coins,amount,dp);
    }
    public int fun(int n,int[] coins,int amount,int[][] dp){
        if(amount==0) return 1;
        if(n==0){
            return (amount%coins[0]==0)? 1:0;
        }
        if(dp[n][amount]!=-1) return dp[n][amount];
        int left=fun(n-1,coins,amount,dp);
        int right=0;
        if(amount>=coins[n]){
             right=fun(n,coins,amount-coins[n],dp);
            
        }
        
        return dp[n][amount]=left+right;
    }
}