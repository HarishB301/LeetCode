class Solution {
    public List<Integer> findPeaks(int[] m) {
        int n=m.length;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<n-1;i++){
            if(m[i-1]<m[i] && m[i]>m[i+1]){
                list.add(i);
            }
        }
        return list;
    }
}