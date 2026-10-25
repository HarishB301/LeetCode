class Solution {
    public int singleNonDuplicate(int[] nums) {
        for(int el:nums){
            int first=lower(nums,el);
            int last=upper(nums,el);
            if(last==first) return nums[last];
            else continue;
        }
        return -1;
        
    }
    int lower(int[] arr,int k){
        int low=0,high=arr.length-1,ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==k){
                ans=mid;
                high=mid-1;
            }else if(arr[mid]>k){
                high=mid-1;
            }else low=mid+1;
        }
        return ans;

    }
     int upper(int[] arr,int k){
        int low=0,high=arr.length-1,ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==k){
                ans=mid;
                low=mid+1;
            }else if(arr[mid]>k){
                high=mid-1;
            }else low=mid+1;
        }
        return ans;

    }
}