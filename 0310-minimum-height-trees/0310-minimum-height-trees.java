class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges){
        List<Integer> res = new ArrayList<>();
        if(n==0) return res;
        if(n==1){
            res.add(0);
            return res;
        }
        int[] degree=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                q.add(i);
            }
        }
        while(n>2){
            int size=q.size();
            n-=size;
            for(int i=0;i<size;i++){
                int node=q.poll();
                for(int ele:adj.get(node)){
                    degree[ele]--;
                    if(degree[ele]==1) q.offer(ele);
                }
            }
        }
        res.addAll(q);
        return res;
       
    }
}