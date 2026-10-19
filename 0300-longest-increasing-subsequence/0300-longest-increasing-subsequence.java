class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+2];
        int[] dp1=new int[n+2];
        dp[n+1]=0;
        for(int i=n-1;i>=0;i--){
           for(int j=i-1;j>=-1;j--){
              int len=dp[j+1];
              if(j==-1 || nums[i]>nums[j]){
                len=Math.max(len,dp[i+1]+1);
              }
              dp1[j+1]=len;
           }
           dp=Arrays.copyOf(dp1,n+2);
        }
        return dp[0];
    }
   
}