class Solution {
    private boolean isValid(int r,int c,int n){
        return r>=0 && r<n && c>=0 && c<n;
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        Disjoint ds =new Disjoint(n*n);
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0) continue;
                int dr[]={-1,1,0,0};
                int dc[]={0,0,-1,1};
                for(int ind=0;ind<4;ind++){
                    int newr=row+dr[ind];
                    int newc=col+dc[ind];
                    if(isValid(newr,newc,n)&& grid[newr][newc]==1){
                        int adj=row*n+col;
                        int adjNode=newr*n+newc;
                        ds.UnionBySize(adj,adjNode);
                    }
                }
            }
        }
         int max=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1) continue;
                int dr[]={-1,1,0,0};
                int dc[]={0,0,-1,1};
                HashSet<Integer> set=new HashSet<>();
                for(int ind=0;ind<4;ind++){
                    int newr=row+dr[ind];
                    int newc=col+dc[ind];
                    if(isValid(newr,newc,n)&& grid[newr][newc]==1){
                        set.add(ds.find(newr*n+newc));
                    }
                }
                int total=0;
                for(int ele:set){
                    total+=ds.Size(ele);
                }
                max=Math.max(max,total+1);
            }
        }

        for(int no=0;no<n*n;no++){
            max=Math.max(max,ds.Size(ds.find(no)));
        }
        return max;

    }
}



class Disjoint{
   public int[] parent;
   public int[] size;
    public Disjoint(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int Size(int n){
      return size[n];
    }

    public int find(int n){
        if(parent[n]==n) return n;
        return parent[n]=find(parent[n]);
    }

    public void UnionBySize(int u,int v){
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
}