class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0,j=0,max=Integer.MIN_VALUE,sum=0;
        while(j<nums.length){
            int num=nums[j];
            sum+=num;
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.size()<(j-i+1)){
                while(map.size()<(j-i+1)){
                    int n=nums[i];
                    map.put(n,map.get(n)-1);
                    sum-=nums[i];
                    if(map.get(n)==0) map.remove(n);
                    i++;
                }
            }
            max=Math.max(sum,max);
            j++;

        }

        return max;

    }
}