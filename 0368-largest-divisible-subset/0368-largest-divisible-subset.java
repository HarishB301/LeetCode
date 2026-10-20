class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int[] dp=new int[n];
        int[] hash=new int[n];
        int lastIndex=0;
        int max=0;
        Arrays.fill(dp,1);

        for(int ind=0;ind<n;ind++){
            hash[ind]=ind;
            for(int pre=0;pre<ind;pre++){
                if(nums[ind]%nums[pre]==0 && 1+dp[pre]>dp[ind]){
                    dp[ind]=1+dp[pre];
                    hash[ind]=pre;
                }
            }
            if(dp[ind]>max){
                max=dp[ind];
                lastIndex=ind;
            }
        }

        ArrayList<Integer> list=new ArrayList<>();
        list.add(nums[lastIndex]);
        while(hash[lastIndex]!=lastIndex){
            lastIndex=hash[lastIndex];
            list.add(nums[lastIndex]);
        }
        Collections.reverse(list);
        return list;
    }
}