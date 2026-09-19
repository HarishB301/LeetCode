class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>>  adj = new ArrayList<>();
        List<List<Integer>>  list = new ArrayList<>();
        if(n==0) return list;
        if(n==1){
            list.add(new ArrayList<>());
            return list;
        }
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
        }
        for(int i=0;i<n;i++){
            dfs(i,i,list,adj);
        }
        return list;
    }

    public void dfs(int node,int ancestor,List<List<Integer>> list,List<List<Integer>> adj){
       
        
        for(int ele:adj.get(node)){
            if(list.get(ele).size()==0 || list.get(ele).get(list.get(ele).size()-1)!=ancestor){
                list.get(ele).add(ancestor);
                dfs(ele,ancestor,list,adj);
            }
        }
        
        
    }
}