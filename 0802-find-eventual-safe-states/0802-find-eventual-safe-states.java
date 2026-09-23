class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj=new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int n=graph.length;
        int degree[] =new int[n];
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                int u=graph[i][j];
                adj.get(u).add(i);
            }
            degree[i]=graph[i].length;
        }
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
             if(degree[i]==0) q.offer(i);   
        }
        while(!q.isEmpty()){
            int node=q.poll();
            vis[node]=true;
            for(int ele:adj.get(node)){
                degree[ele]-=1;
                if(degree[ele]==0) q.offer(ele);
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i]) list.add(i);
        }
        return list;
    
    }
}