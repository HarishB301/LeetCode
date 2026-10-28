class Solution {
    public int smallestDivisor(int[] nums, int t) {
        int n=nums.length;
        int high=-1,low=1;
        for(int ele:nums){
            high=Math.max(high,ele);
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            int tresh=fun(nums,mid);
            if(tresh<=t){
                high=mid-1;
            }else low=mid+1;
        }
        return low;
    }

    public int fun(int[] arr,int mid){
        int sum=0;
        for(int ele:arr){
            sum+=(ele+mid-1)/mid;
        }
        return sum;
    }
}