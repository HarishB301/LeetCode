class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int i=0,j=0,kzeros=0,max=Integer.MIN_VALUE;
        while(j<nums.length){
            if(nums[j]==0){
                    kzeros++;
            }
            if(kzeros>k){
                if(nums[i]==0){
                    kzeros--;
                }
                    i++;
              }
              j++;
              max=Math.max(max,(j-i+1));
        }

        return max-1;

    }
}