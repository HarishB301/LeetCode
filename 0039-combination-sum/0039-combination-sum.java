class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        sum(nums,list,new ArrayList<>(),0,target);
        return list;
    }

    public void sum(int[] nums,List<List<Integer>>list,List<Integer> res,int index,int target){
            if(target==0){
                list.add(new ArrayList<>(res));    
            }
            else if(target<0) return;
            else{
                 for(int i=index;i<nums.length;i++){
                res.add(nums[i]);
                sum(nums,list,res,i,target-nums[i]);
                res.remove(res.size()-1);
                }
            }
    }
}