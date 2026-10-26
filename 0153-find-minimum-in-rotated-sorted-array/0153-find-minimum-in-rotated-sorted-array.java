class Solution {
    public int findMin(int[] nums) {

       int n=nums.length;
        if(n==1) return nums[0];
        int low =0,high=n-1,ans=-1;
        while(low<=high){
             int mid = low + (high - low) / 2;
        
        if (nums[mid] > nums[high]) {
            // The minimum must be in the right sorted part
            low = mid + 1;
        } else if (nums[mid] < nums[high]) {
            // The minimum is at mid or to the left of mid
            high = mid;
        } else {
            // When nums[mid] == nums[high], we can't be sure which side to go.
            // Safely shrink the search space by moving the high pointer.
            high--;
        }
    }
        return nums[low];
    }
}