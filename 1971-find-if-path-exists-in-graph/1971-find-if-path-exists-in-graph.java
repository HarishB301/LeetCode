class Solution {
    public boolean validPath(int n, int[][] edges, int s, int d) {
        if(s==d) return true;
        boolean visited[] = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList<>());
        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        bfs(s,visited,list,n);
        // for(int i=s;i<=d;i++) if(visited[i]==false) return false;
        return visited[d];
    }

    public void bfs(int s,boolean[] visited,List<List<Integer>> list ,int n){
        visited[s]=true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        while(!q.isEmpty()){
            int front = q.poll();
            for(int ele:list.get(front)){
                if(!visited[ele]){
                    visited[ele]=true;
                    q.offer(ele);
                }
            }
        }

    }
}