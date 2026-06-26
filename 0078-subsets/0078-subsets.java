class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        sets(nums,new ArrayList<>(),list,0);
        //  Collections.reverse(list);
         return list;
    }

    public void sets(int[] nums,List<Integer> res,List<List<Integer>> list,int index){
        if(nums.length==index){
            list.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[index]);
        sets(nums,res,list,index+1);
        res.remove(res.size()-1);
        sets(nums,res,list,index+1);
    }
}