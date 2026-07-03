class Solution {
    public List<List<Integer>> combinationSum(int[] can, int target) {
        List<List<Integer>> list=new ArrayList<>();
        sum(list,new ArrayList<>(),can,target,0);
        return list;
    }

    public void sum(List<List<Integer>> list,List<Integer> res,int[] can,int target,int index){
        if(target==0){         
            list.add(new ArrayList<>(res));    
            return;
        }
        else if(target<0) return;
        else{
            for(int i=index;i<can.length;i++){
                res.add(can[i]);
                sum(list,res,can,target-can[i],i);
                res.remove(res.size()-1);
            }
        }
    }
}