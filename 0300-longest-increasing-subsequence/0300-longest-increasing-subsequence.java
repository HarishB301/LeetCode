class Solution {
    public int lengthOfLIS(int[] nums) {
       List<Integer> list = new ArrayList<>();
       for(int num:nums){
         int ind=Collections.binarySearch(list,num);
         if(ind<0) ind=-(ind+1);
         if(ind==list.size()) list.add(num);
         else list.set(ind,num);
       }
       return list.size();
    }
   
}