class Solution {
    public int findCircleNum(int[][] adj) {
        int n=adj.length;
        boolean visited[]=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
           if(!visited[i]){
            bfs(i,adj,visited);
            count++;
           }
        }

        return count++;
    }

    public void bfs(int start,int[][] adj,boolean visited[]){
        visited[start]=true;
        Queue<Integer> q =new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int front = q.poll();
            for(int i=0;i<adj.length;i++){
                if(adj[front][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }

        }
    }
}