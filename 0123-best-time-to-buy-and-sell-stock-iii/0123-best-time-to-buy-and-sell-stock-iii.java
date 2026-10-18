class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] dp=new int[5];
        int[] dp1=new int[5];
        for(int trans=0;trans<4;trans++){
            dp[trans]=0;
        }
        dp[3]=0;
        
        for(int ind=n-1;ind>=0;ind--){
            for(int trans=3;trans>=0;trans--){
                if(trans%2==0){
                      dp1[trans]=Math.max(dp[trans+1]-prices[ind],dp[trans]);
                }else{
                    dp1[trans]=Math.max(dp[trans+1]+prices[ind],dp[trans]);
                }
            }
            dp=Arrays.copyOf(dp1,5);
        }
        return dp[0];
        
    }
   
   
}