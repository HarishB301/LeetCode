class Solution {
    public int longestSubarray(int[] nums) {
        int i=0,j=0,Zeros=0,max=0;
        for(j=0;j<nums.length;j++){
            if(nums[j]==0) Zeros++;
            while(Zeros>1){
                if(nums[i]==0) Zeros--;
                i++;
            }
            max=Math.max(max,j-i);
        }

        return max;
       
    }
}