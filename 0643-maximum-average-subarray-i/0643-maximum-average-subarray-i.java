class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg= Integer.MIN_VALUE;
        int i=0,j=0;
        double sum=0.00;
        while(j<nums.length){
            sum+=nums[j];
            if((j-i+1)==k){
                avg=Math.max(avg,sum);
                sum-=nums[i];
                i++;
            }
             j++;
            
        }

        double maxAvg=avg/k;


        return maxAvg;
    }
}