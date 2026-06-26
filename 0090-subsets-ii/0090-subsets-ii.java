class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        sets(nums,new ArrayList<>(),list,0);
        return list;
    }

    public void sets(int[] nums,List<Integer> res,List<List<Integer>> list,int index){
        list.add(new ArrayList<>(res));

        for(int i=index;i<nums.length;i++){
            if(i!=index && nums[i]==nums[i-1]) continue;
            res.add(nums[i]);
            sets(nums,res,list,i+1);
            res.remove(res.size()-1);
        }
    }
}