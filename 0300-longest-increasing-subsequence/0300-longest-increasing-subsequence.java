class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,1);
        int max=0;
        for(int ind=0;ind<n;ind++){
           for(int prev=0;prev<ind;prev++){
              if(nums[prev]<nums[ind]){
                dp[ind]=Math.max(1+dp[prev],dp[ind]);
              }
           }
                max=Math.max(max,dp[ind]);
          
        }
        return max;
    }
   
}