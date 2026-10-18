class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];
        for(int ind=0;ind<n;ind++){
            dp[ind][0][0]=0;
            dp[ind][1][0]=0;
        }

        for(int k=0;k<3;k++){
            dp[n][0][k]=0;
            dp[n][1][k]=0;
        }

        for(int ind=n-1;ind>=0;ind--){
                for(int k=1;k<=2;k++){
                   dp[ind][1][k]=Math.max(dp[ind+1][0][k]-prices[ind],dp[ind+1][1][k]);
                   dp[ind][0][k]=Math.max(dp[ind+1][1][k-1]+prices[ind],dp[ind+1][0][k]);   
                }
            
        }
        return dp[0][1][2];
        
    }
   
}