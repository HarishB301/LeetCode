class Solution {
    boolean ans=true;
    public boolean isBipartite(int[][] graph) {
        
        int n=graph.length;
        int visited[] =new int[n];
        Arrays.fill(visited,-1);
        for(int i=0;i<n;i++){
            if(ans==false) return ans;
            if(visited[i]==-1){
               bfs(i,visited,graph);
            }
        }
        return ans;
    }

    public void bfs(int start,int[] visited,int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start]=0;
        while(!q.isEmpty()){
            int front = q.poll();
            int color = visited[front];
            for(int ele:graph[front]){
                if(visited[ele]==visited[front]){
                    ans=false;
                    return;
                }
                if(visited[ele]==-1){
                    visited[ele]=1-color;
                    q.offer(ele);
                }
            }
        }

       
    }
}