class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return fun(nums,0,-1,dp);
    }
    int fun(int[] nums,int ind,int prev,int[][] dp){
        if(ind==nums.length) return 0;
        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];
        int len=0+fun(nums,ind+1,prev,dp);
        if(prev==-1 || nums[ind]>nums[prev]){
            len=Math.max(len,1+fun(nums,ind+1,ind,dp));
        }
        return dp[ind][prev+1]=len;
    }
}