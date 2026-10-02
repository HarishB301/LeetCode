class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(dp,n,nums,0);

    }
    public int helper(int[] dp,int n,int[] nums,int idx){
        if(idx==n-1) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int minSteps=Integer.MAX_VALUE;
        for(int i=1;i<=nums[idx];i++){
            int jump=Integer.MAX_VALUE;
            if(idx+i<n){
                jump=helper(dp,n,nums,idx+i);
            }
            if(jump!=Integer.MAX_VALUE){
                minSteps=Math.min(jump+1,minSteps);
            }
        }
        return dp[idx]=minSteps;
    }
}