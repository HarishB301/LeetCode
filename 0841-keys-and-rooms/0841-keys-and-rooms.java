class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited=new boolean[n];
        
        bfs(0,visited,rooms);
            
        
        for(boolean vis:visited){
            if(vis==false) return false;
         }

         return true;
    }

    public void bfs(int start,boolean[] visited,List<List<Integer>> rooms){
        Queue<Integer> q= new LinkedList<>();
        q.offer(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int front = q.poll();
            for(int ele:rooms.get(front)){
                if(!visited[ele]){
                    visited[ele]=true;
                    q.offer(ele);
                }
            }
        }
    }
}