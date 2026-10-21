class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++) arr[i+1]=nums[i];
        int[][] dp=new int[n+2][n+2];
         for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                int maxCost=Integer.MIN_VALUE;
                for(int cut=i;cut<=j;cut++){
                    int cost=(arr[i-1]*arr[cut]*arr[j+1])+dp[i][cut-1]+dp[cut+1][j];
                    maxCost=Math.max(maxCost,cost);
                dp[i][j]=maxCost;
                }
            }
         }
         return dp[1][n];
    }
    
}