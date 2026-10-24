class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=1;i<=n;i++){
            int lb=lower(nums,i);
            if(lb!=-1){
                int count=n-lb;
                if(count==i) return i;
            }
        }
        return -1;

    }

    int lower(int[] nums,int k){
        int low=0,high=nums.length-1,ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=k){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    }
}