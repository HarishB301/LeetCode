class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE, maxSum = 0;
        int min = Integer.MAX_VALUE, minSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += nums[i];
            max = Math.max(max, maxSum);
            if (maxSum < 0)
                maxSum = 0;
            
            minSum += nums[i];
            min = Math.min(min, minSum);
            if (minSum > 0)
                minSum = 0;
        }
        return Math.max(max,Math.abs(min));
    }
}