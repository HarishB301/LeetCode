class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> con) {
        List<List<Integer>> adj=new ArrayList<>();
        List<List<Integer>> bridges=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(List<Integer> list:con){
            int u=list.get(0);
            int v=list.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int time=0;
        int[] vis=new int[n];
        int[] dtime=new int[n];
        int[] low=new int[n];
        dfs(0,-1,vis,dtime,low,adj,bridges,time);
        return bridges;

    }

    public void dfs(int node,int parent,int[] vis,int[] dtime,int[] low,List<List<Integer>> adj,List<List<Integer>> bridges,int time){
        vis[node]=1;
        low[node]=dtime[node]=++time;
        for(int it:adj.get(node)){
            if(it==parent) continue;
            if(vis[it]==0){
                dfs(it,node,vis,dtime,low,adj,bridges,time);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>dtime[node]){
                    bridges.add(Arrays.asList(node,it));
                }
            }else{
                low[node]=Math.min(low[node],low[it]);
            }
        }

    }
}