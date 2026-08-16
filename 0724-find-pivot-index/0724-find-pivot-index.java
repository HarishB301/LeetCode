class Solution {
    public int pivotIndex(int[] nums) {
        int total_sum=0;
        for(int n:nums) total_sum+=n;
        int left_sum=0;
        for(int i=0;i<nums.length;i++){
            int right_sum=total_sum-left_sum-nums[i];
            if(right_sum==left_sum) return i;
            left_sum+=nums[i];
        }
        return -1;
    }
}