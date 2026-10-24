class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int Slen=spells.length;
        int Plen=potions.length;
        int[] result=new int[Slen];


        for(int i=0;i<Slen;i++){
            int res=lower(potions,success,spells[i]);
            result[i]= res==Plen ? 0 : Plen-res;
        }

        return result;
    }

    int lower(int[] nums,long target,int s){
        int start=0,end=nums.length-1;
        while(start<=end){
        int mid=start+(end-start)/2;
        if(((long)s*nums[mid])>=target){
            end=mid-1;
        }else
            start=mid+1;
        }

        return start; 
    }
}