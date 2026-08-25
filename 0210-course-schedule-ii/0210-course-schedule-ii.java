class Solution {
    public int[] findOrder(int n, int[][] adj) {
               int m=adj.length;
        List<Integer> res = new ArrayList<>();
        
        int[] Indegree = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int course=adj[i][0];
            int preq=adj[i][1];
            list.get(preq).add(course);
            Indegree[course]++;
        }
       
        Queue<Integer> q =new LinkedList<>();
        for(int k=0;k<n;k++) if(Indegree[k]==0) q.offer(k);
        
        while(!q.isEmpty()){
            int node=q.poll();
            res.add(node);
            for(int ele:list.get(node)){
                Indegree[ele]--;
                if(Indegree[ele]==0) q.offer(ele);
            }
        }
        if (res.size() != n) {
            return new int[0];
        }
        int index=0;
        int[] res1=new int[res.size()];
        for(int ele:res) res1[index++]=ele;
        return res1;
    }
}