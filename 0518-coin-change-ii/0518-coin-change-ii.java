class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        // for(int[] arr:dp) Arrays.fill(arr,-1);
        // return fun(n-1,coins,amount,dp);
        for(int i=0;i<n;i++){
            int[] dp1=new int[amount+1];
            for(int j=0;j<=amount;j++){
                if(j==0) dp1[j]=1;
                else if(i==0){
                    if(j%coins[0]==0){
                        dp1[j]=1;
                    }else dp1[j]=0;
                }else{
                    int left=dp[j];
                    int right=0;
                    if(j>=coins[i]){
                        right=dp1[j-coins[i]];
                        
                    }
                   dp1[j]=left+right;
                }
            }
                dp=Arrays.copyOf(dp1,amount+1);
        }
        return dp[amount];
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