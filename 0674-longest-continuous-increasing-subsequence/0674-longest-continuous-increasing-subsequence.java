class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n=nums.length;
        int maxi=1;
        int maxLen=1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1] ){
                maxi++;
            }
            else maxi=1;
            maxLen=Math.max(maxLen,maxi);
        }

        return maxLen;
    }
}