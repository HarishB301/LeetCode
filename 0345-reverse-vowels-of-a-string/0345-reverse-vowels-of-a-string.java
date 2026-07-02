class Solution {
    public String reverseVowels(String s) {
        int start=0,end=s.length()-1;
        char str[]=s.toCharArray();
        while(start<end){
           if(!check(str[start])) start++;
           else if(!check(str[end])) end--;
           else{
               char temp=str[start];
                str[start]=str[end];
                str[end]=temp;
                start++;
                end--;
           }
             
        }
        String string = new String(str);
        return string;
    }

    
    public boolean check(char ch){
       char vow = Character.toLowerCase(ch);
        return (vow=='a'||vow=='e'||vow=='i'||vow=='o'||vow=='u');
    }
}