class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map =new HashMap<>();
        int i=0,j=0,max=Integer.MIN_VALUE,maxFreq=0;;
        while(j<s.length()){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxFreq = Math.max(maxFreq,map.get(ch));
                int window = j-i+1;
                int replace = window-maxFreq;
                while(replace>k){
                    char a = s.charAt(i);
                    map.put(a,map.get(a)-1);
                    i++;
                    window=j-i+1;
                    replace=window-maxFreq;
                }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;

    }
}