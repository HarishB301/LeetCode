class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++) arr[i+1]=nums[i];
        int[][] dp=new int[n+2][n+2];
        for(int a[]:dp) Arrays.fill(a,-1);
        return fun(1,n,arr,dp);
    }
    int fun(int i,int j,int[] arr,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int maxCost=Integer.MIN_VALUE;
        for(int cut=i;cut<=j;cut++){
              int cost=(arr[i-1]*arr[cut]*arr[j+1])+fun(i,cut-1,arr,dp)+fun(cut+1,j,arr,dp);
              maxCost=Math.max(maxCost,cost);
        }
        return dp[i][j]=maxCost;
    }
}