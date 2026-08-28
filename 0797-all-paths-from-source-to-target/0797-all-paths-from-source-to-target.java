class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> list = new ArrayList<>();
        dfs(0,list,n,new ArrayList<Integer>(),graph);
        return list;
    }

    public void dfs(int start,List<List<Integer>> list,int n,ArrayList<Integer> path,int[][] graph){
         path.add(start);
        if(start==n-1){
            list.add(new ArrayList<>(path));
        }
        for(int ele:graph[start]){
                dfs(ele,list,n,path,graph);
        }
        path.remove(path.size()-1);
    }
}