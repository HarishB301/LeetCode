class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        
        int[] edge1 = null;
        int[] edge2 = null;

        // Step 1: Detect node with two incoming edges (indegree = 2)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (parent[v] != 0) {
                // Node 'v' already has a parent!
                edge1 = new int[]{parent[v], v}; // First incoming edge
                edge2 = new int[]{u, v};         // Second incoming edge
                break;
            } else {
                parent[v] = u; // Store actual parent node u
            }
        }

        // Step 2: Use Union-Find to detect cycles
        Disjoint ds = new Disjoint(n + 1);

        for (int[] edge : edges) {
            // Skip edge2 temporarily if a double-parent exists
            if (edge2 != null && edge[0] == edge2[0] && edge[1] == edge2[1]) {
                continue;
            }

            int u = edge[0];
            int v = edge[1];

            // Cycle detected!
            if (ds.find(u) == ds.find(v)) {
                // Case 3: Double parent AND cycle exist -> edge1 causes the cycle
                if (edge1 != null) {
                    return edge1;
                }
                // Case 2: Only cycle exists -> remove current edge
                return edge;
            }

            ds.UnionBySize(u, v);
        }

        // Case 1: Double parent exists, but no cycle -> remove edge2
        return edge2;

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