class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalSum=0;
        for(int i=0;i<n;i++) totalSum+=nums[i];
        if(totalSum%2!=0) return false;
        int sum=totalSum/2;
        int[][] dp=new int[n][sum+1];
        for(int arr[]:dp) Arrays.fill(arr,-1);
        return Equal(n-1,sum,nums,dp)==1;
    }
    public int Equal(int ind,int target,int[] nums,int[][] dp){
        if(target==0) return 1;
        if(ind==0) return nums[ind]==target?1:0;
        if(dp[ind][target]!=-1) return dp[ind][target];
        int notTaken=Equal(ind-1,target,nums,dp);
        int take=0;
        if(target>=nums[ind]){
            take=Equal(ind-1,target-nums[ind],nums,dp);
        }
        return dp[ind][target]=Math.max(notTaken,take);
    }

}