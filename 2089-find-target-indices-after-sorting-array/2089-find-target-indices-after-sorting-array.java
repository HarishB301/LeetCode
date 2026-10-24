class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int less=0,equal=0;
        List<Integer> list=new ArrayList<>();
        for(int ele:nums){
            if(ele<target) less++;
            else if(ele==target) equal++;
        }
        for(int i=0;i<equal;i++){
            list.add(less+i);
        }

        return list;
    }
}