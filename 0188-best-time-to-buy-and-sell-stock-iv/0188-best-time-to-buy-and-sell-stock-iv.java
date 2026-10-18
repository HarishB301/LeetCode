class Solution {
    public int maxProfit(int k, int[] prices) {
         int n=prices.length;
         int tt=2*k+1;
        int[] dp=new int[tt];
        int[] dp1=new int[tt];
        for(int trans=0;trans<tt;trans++){
            dp[trans]=0;
        }
        dp[tt-1]=0;
        
        for(int ind=n-1;ind>=0;ind--){
            for(int trans=tt-2;trans>=0;trans--){
                if(trans%2==0){
                      dp1[trans]=Math.max(dp[trans+1]-prices[ind],dp[trans]);
                }else{
                    dp1[trans]=Math.max(dp[trans+1]+prices[ind],dp[trans]);
                }
            }
            dp=Arrays.copyOf(dp1,tt);
        }
        return dp[0];
    }
}