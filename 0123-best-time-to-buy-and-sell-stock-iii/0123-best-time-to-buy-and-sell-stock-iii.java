class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[2][3];
        int[][] dp1=new int[2][3];
            dp[0][0]=0;
            dp[1][0]=0;
        

        for(int k=0;k<3;k++){
            dp[0][k]=0;
            dp[1][k]=0;
        }

        for(int ind=n-1;ind>=0;ind--){
                for(int k=1;k<=2;k++){
                   dp1[1][k]=Math.max(dp[0][k]-prices[ind],dp[1][k]);
                   dp1[0][k]=Math.max(dp[1][k-1]+prices[ind],dp[0][k]);   
                }
                for (int i = 0; i < dp1.length; i++) {
                     dp[i] = dp1[i].clone(); 
                }
            
        }
        return dp[1][2];
        
    }
   
}