class Solution {
    public int totalFruit(int[] arr) {
        if(arr.length==1) return 1;
        if(arr.length==0) return 0;
        HashMap<Integer,Integer> map= new HashMap<>();
        int i=0,j=0,max=0;
        while(j<arr.length){
            int ch=arr[j];
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size()==2 || map.size()==1){
                max=Math.max(max,(j-i+1));
                j++;
            }else if(map.size()<2){
                j++;
            }else{
                while(map.size()>2){
                    int n=arr[i];
                    map.put(n,map.get(n)-1);
                    if(map.get(n)==0){
                        map.remove(arr[i]);
                    }
                    i++;
                }
                j++;
            }
        }

        return max;

    }
}