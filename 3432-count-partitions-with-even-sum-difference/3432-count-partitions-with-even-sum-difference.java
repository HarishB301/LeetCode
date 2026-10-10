class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int ele:nums) sum+=ele;
        int SubSum=0;
        int count=0;
        for(int i=0;i<n-1;i++){
            sum-=nums[i];
            SubSum+=nums[i];
            if(Math.abs(SubSum-sum)%2==0){
               count++;
            }
        }

        return count;
    }
}