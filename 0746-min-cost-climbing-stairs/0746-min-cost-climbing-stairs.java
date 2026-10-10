class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return Math.min(fun(cost,n-1,dp),fun(cost,n-2,dp));
    }
    public int fun(int[] cost,int n,int[] dp){
        if(n==0||n==1){
            return cost[n];
        }
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int left=fun(cost,n-1,dp);
        int right=fun(cost,n-2,dp);
        return dp[n]=Math.min(left,right)+cost[n];

    }
}