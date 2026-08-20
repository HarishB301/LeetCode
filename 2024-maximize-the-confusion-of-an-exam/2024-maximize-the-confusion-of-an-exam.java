class Solution {
    public int maxConsecutiveAnswers(String str, int k) {
        int count[]=new int[2];
         int len=0,j=0;
        for(int i=0;i<str.length();i++){
            char ch =str.charAt(i);
            if(ch=='T'){
                count[1]++;
            }else count[0]++;
            if(count[0]>k && count[1]>k){
                while(count[0]>k && count[1]>k){
                    char c =str.charAt(j);
                    if(c=='T') count[1]--;
                    else count[0]--;
                    j++;
                }
            }
            len=Math.max(len,(i-j+1));
        }

        return len;

    }
}