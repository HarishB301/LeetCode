class Solution {
    public boolean checkInclusion(String s1, String s2) {
          int[] fre1=new int[26];
          int[] fre2=new int[26];
          for(int i=0;i<s1.length();i++){
            fre1[s1.charAt(i)-'a']++;
            fre2[s2.charAt(i)-'a']++;
          }

          if(Arrays.equals(fre1,fre2)) return true;
          int start=0;
          int end=s1.length();
          while(end<s2.length()){
            fre2[s2.charAt(start)-'a']--;
            fre2[s2.charAt(end)-'a']++;
            if(Arrays.equals(fre1,fre2)) return true;
            start++;
            end++;
          }

          return false;
    }
}