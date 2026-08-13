class Solution {
    public int maxVowels(String s, int k) {
        int maxVowel=0;
        int i=0,j=0;
        int vowel=0;
        while(j<s.length()){
            if(isVowel(s.charAt(j))) vowel++;
            if((j-i+1)==k){
               maxVowel=Math.max(maxVowel,vowel);
               if(isVowel(s.charAt(i))) vowel--;
               i++;
            }
            j++;
        }

        return maxVowel;
    }

    public boolean isVowel(char s){
        return s=='a' || s=='e' || s=='i'||s=='o'||s=='u';
    }
}