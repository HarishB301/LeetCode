class Solution {
    public List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> list = new ArrayList<>();
       solve(list,new ArrayList<>(),n,k,1);
       return list; 
    }

    public void solve(List<List<Integer>> list,List<Integer> res,int n,int k,int index){
        if(res.size()==k){
            list.add(new ArrayList<>(res));
            return;
        }else if(res.size()>k) return;

        for(int i=index;i<=n;i++){
            res.add(i);
            solve(list,res,n,k,i+1);
            res.remove(res.size()-1);
        }
    }
}