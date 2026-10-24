class Solution {
    public int maximumCount(int[] nums) {
       int neg=bs(nums,0);
       int pos=nums.length-bs(nums,1);
       return Math.max(neg,pos);

    }
    int bs(int[] nums,int k){
        int i=0,j=nums.length-1,ans=nums.length;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]>=k){
                ans=mid;
                j=mid-1;
            }else{
                i=mid+1;
            }
        }

        return ans;
        
    }
    
}