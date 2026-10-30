class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int counter=0;
            for(int num:nums){
                if(mid>=num) counter++;
            }

            if(counter>mid){
                high=mid-1;
            }else low=mid+1;
        }
        return low;

        // for(int i=0;i<n;i++){
        //     if(nums[i]-1!=i){
        //         int temp=nums[nums[i]-1];
        //         nums[nums[i]-1]=nums[i];
        //         nums[i]=temp;

        //     }
        // }

        // for(int i=0;i<n;i++){
        //     if(nums[i]-1!=i) return nums[i];
        // }
        // return -1;
    }

    
}