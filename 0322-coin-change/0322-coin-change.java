class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        // for(int[] arr:dp) Arrays.fill(arr,-1);
        // int ans=fun(n-1,coins,amount,dp);
        // return ans==Integer.MAX_VALUE ? -1: ans;

        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                if(j==0) dp[i][j]=0;
                else if(i==0){
                    if(j%coins[0]==0){
                        dp[i][j]=j/coins[0];
                    }else dp[i][j]=Integer.MAX_VALUE;
                }else{
                    int left=dp[i-1][j];
                    int right=Integer.MAX_VALUE;
                    if(j>=coins[i]){
                        int ans=dp[i][j-coins[i]];
                        if(ans!=Integer.MAX_VALUE){
                              right=1+ans;
                        }
                    }
                   dp[i][j]=Math.min(left,right);
                }
            }
        }
        return dp[n-1][amount]==Integer.MAX_VALUE ? -1 : dp[n-1][amount];
    }
    public int fun(int n,int[] coins,int amount,int[][] dp){
        if(amount==0) return 0;
        if(n==0){
            if((amount%coins[0])==0) return amount/coins[0];
            return Integer.MAX_VALUE;
        }
        if(dp[n][amount]!=-1) return dp[n][amount];
        int left=fun(n-1,coins,amount,dp);
        int right=Integer.MAX_VALUE;
        if(amount>=coins[n]){
            int ans=fun(n,coins,amount-coins[n],dp);
            if(ans!=Integer.MAX_VALUE){
                right=1+ans;
            }
        }
        
        return dp[n][amount]=Math.min(left,right);
    }
}