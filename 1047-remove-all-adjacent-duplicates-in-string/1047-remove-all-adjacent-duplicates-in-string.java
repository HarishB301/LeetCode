class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> str=new Stack<>();
        String Adj="";
        for(char ch:s.toCharArray()){
            if(!str.isEmpty() && str.peek()==ch) str.pop();
            else str.push(ch);
        }
        for(char ch:str) Adj+=ch;
        return Adj;
    }
}