class Solution {    
    public int numberOfSubstrings(String s) {
         int count =0;
         int a=0,b=0,c=0;
         int left=0,n=s.length();
         for(int right=0;right<n;right++){
              char ch = s.charAt(right);
              if(ch=='a') a++;
              else if(ch=='b') b++;
              else c++;

              while(a>0 && b>0 && c>0){
                count+=(n-right);
                char ch1=s.charAt(left);
                if(ch1=='a') a--;
                else if(ch1=='b') b--;
                else c--;
                left++;
              }
         }

         return count;

  
    }
}