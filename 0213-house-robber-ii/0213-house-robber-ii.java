class Solution {
    public int rob(int[] nums) {
         int n=nums.length;
        if(nums==null || n==0) return 0;
        if(n==1) return nums[0];
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        for(int i=0;i<n;i++){
            if(i!=0) arr1[i]=nums[i];
            if(i!=n-1) arr2[i]=nums[i];
        }
        return Math.max(rob1(arr1),rob1(arr2));
    }
    public int rob1(int[] nums) {
        int n=nums.length;
        if(nums==null || n==0) return 0;
        if(n==1) return nums[0];
        int prev2=nums[0];
        int prev1=Math.max(nums[0],nums[1]);
        int curr=prev1;
        for(int i=2;i<n;i++){
            int pick=nums[i]+prev2;
            int non_pick=prev1;
            curr=Math.max(pick,non_pick);
            prev2=prev1;
            prev1=curr;
        }
        return curr;
    }
}