class Solution {
    int[] parent;
    int[] size;
    public int find(int node){
        if(parent[node]==node) return node;
        return find(parent[node]);
    }
    public void unionBySize(int u,int v){
        int uRoot=find(u);
        int vRoot=find(v);
        if(uRoot==vRoot) return;
        if(size[uRoot]<size[vRoot]){
            parent[uRoot]=vRoot;
            size[vRoot]+=size[uRoot];
        }else{
            parent[vRoot]=uRoot;
            size[uRoot]+=size[vRoot];
        }
    }
    public int makeConnected(int n, int[][] con) {
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        int countExtras=0;
        for(int i=0;i<con.length;i++){
             int u=con[i][0];
             int v=con[i][1];
             if(find(u)==find(v)){
                 countExtras++;
             }else{
                unionBySize(u,v);
             }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i) count++;
        }
        count-=1;
        if(countExtras>=count) return count;
        return -1;
    }
}