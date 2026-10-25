class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null)  return new int[]{-1,-1};
        int first=lower(nums,target);
        if(first==-1) return new int[]{-1,-1};
        int last=upper(nums,target);
        return new int[]{first,last};
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