class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] Indegree=new int[n+1];
        for(int[] arr:trust ){
            int a=arr[0];
            int b=arr[1];
            Indegree[a]--;
            Indegree[b]++;
        }
        for(int i=1;i<=n;i++){
            if(Indegree[i]==n-1) return i;
        }

        return -1;

    }
}