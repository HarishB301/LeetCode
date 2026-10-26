class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int low=0,high=n-1,ans=Integer.MAX_VALUE;
       while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]>nums[high]){
                ans=Math.min(ans,nums[high]);
                low=mid+1;
            }else if(nums[mid]<nums[high]){
                ans=Math.min(ans,nums[mid]);
                high=mid;    
            }
            else{
                ans=Math.min(ans,nums[mid]);
               high--;
            }
        }
        return ans;
    
    }
}