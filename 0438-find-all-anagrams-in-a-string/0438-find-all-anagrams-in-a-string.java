class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length()<p.length()) return list;

        int Sfreq[] = new int[26]; 
        int Pfreq[] = new int[26]; 
        for(int i=0;i<p.length();i++){
            Sfreq[s.charAt(i)-'a']++;
            Pfreq[p.charAt(i)-'a']++;
        }

        if(Arrays.equals(Sfreq,Pfreq)) list.add(0);
        int start=0;
        int end = p.length();

        while(end<s.length()){
            Sfreq[s.charAt(start)-'a']--;
            Sfreq[s.charAt(end)-'a']++;
            if(Arrays.equals(Sfreq,Pfreq)) list.add(start+1);
            end++;
            start++;

        }

        return list;
    }
}