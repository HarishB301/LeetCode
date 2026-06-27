class Solution {
    public List<List<Integer>> combinationSum2(int[] can, int target) {
        Arrays.sort(can);
        List<List<Integer>> list = new ArrayList<>();
        sum(list,new ArrayList<>(),can,target,0);
        return list;
    }

    public void sum(List<List<Integer>> list,List<Integer> res,int[] arr,int target,int index){
        if(target==0){
            list.add(new ArrayList<>(res));
            return;
        }else if(target<0) return;
        else{
            for(int i=index;i<arr.length;i++){
                if(i>index && arr[i]==arr[i-1]) continue;
                res.add(arr[i]);
                sum(list,res,arr,target-arr[i],i+1);
                res.remove(res.size()-1);
            }
        }
        
    }
}