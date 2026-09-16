class Disjoint{
    int[] parent;
    int[] size;
    public Disjoint(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int find(int i){
        if(parent[i] == i) {
                return i;
        }
        return parent[i] = find(parent[i]);
    }
    public void UnionBysSize(int u,int v){
        int uRoot=find(u);
        int vRoot=find(v);
        if(uRoot==vRoot) return;
        if(size[uRoot]<size[vRoot]){
            parent[uRoot]=vRoot;
            size[vRoot]+=size[uRoot];
        }else{
            parent[vRoot]=uRoot;
            size[uRoot]+=size[vRoot];
        }
    }

    public int MaxSize(){
        int max=0;
        for(int ele:size){
            max=Math.max(ele,max);
        }
        return max;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0 || nums==null) return 0;
        Disjoint ds = new Disjoint(n);
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])) continue;
            map.put(nums[i],i);
            if(map.containsKey(nums[i]+1)){
               ds.UnionBysSize(i,map.get(nums[i]+1));
            }
            if(map.containsKey(nums[i]-1)){
               ds.UnionBysSize(i,map.get(nums[i]-1));
            }
        }

        return ds.MaxSize();
    }
}