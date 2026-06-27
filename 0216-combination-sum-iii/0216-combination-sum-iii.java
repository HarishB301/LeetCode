class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        sum(list,new ArrayList<>(),k,n,1);
        return list;
    }
    public void sum(List<List<Integer>> list,List<Integer> res,int k,int n,int index){
        if(n==0 && res.size()==k){
            list.add(new ArrayList<>(res));
            return;
        }else if(n<0 || res.size()>k) return;
        else{
            for(int i=index;i<=9;i++){
                res.add(i);
                sum(list,res,k,n-i,i+1);
                res.remove(res.size()-1);
            }
        }
    }
}