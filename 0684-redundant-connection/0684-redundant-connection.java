class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        Disjoint ds=new Disjoint(n+1);
        boolean[] vis=new boolean[n+1];
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
           
                if(ds.find(u)==ds.find(v)){
                    return new int[]{u,v};
                }
                ds.UnionBySize(u,v);
            
        }

        return new int[0];

    }
}

class Disjoint{
    private int[] parent;
    private int[] Size;
    public Disjoint(int n){
        parent=new int[n];
        Size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            Size[i]=1;
        }
    }

    public int find(int node){
        if(parent[node]==node) return node;
        return parent[node]=find(parent[node]);
    }

    public void UnionBySize(int u,int v){
        int uRoot=find(u);
        int vRoot=find(v);
        if(uRoot==vRoot) return;
        if(Size[uRoot]<Size[vRoot]){
            parent[uRoot]=vRoot;
            Size[vRoot]+=Size[uRoot];
        }else{
            parent[vRoot]=uRoot;
            Size[uRoot]+=Size[vRoot];
        }
    }

}