class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> str=new Stack<>();
        String Adj="";
        for(char ch:s.toCharArray()){
            if(str.isEmpty()) str.push(ch);
            else if(str.peek()!=ch) str.push(ch);
            else str.pop();
        }
        while(!str.isEmpty()){
            Adj+=str.pop();
        }
        String string="";
        for(int i=Adj.length()-1;i>=0;i--) string+=Adj.charAt(i);


        return string;
    }
}