class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int i=0,j=0,maxLen=-1;
        HashMap<Character,Integer> map =new HashMap<>();

        while(j<s.length()){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if((j-i+1)==map.size()){
                maxLen=Math.max(maxLen,(j-i+1));
            }else{
                while((j-i+1)>map.size()){
                    char ch1 = s.charAt(i);
                    map.put(ch1,map.get(ch1)-1);
                    
                    if(map.get(ch1)==0){
                        map.remove(ch1);
                    }
                    i++;
                }
            }
            j++;
        }

        return maxLen;
    }
}