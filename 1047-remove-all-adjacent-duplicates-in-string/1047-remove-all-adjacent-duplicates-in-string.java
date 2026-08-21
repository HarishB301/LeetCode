class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> str=new Stack<>();
        String Adj="";
        for(char ch:s.toCharArray()){
            if(str.isEmpty()) str.push(ch);
            else if(str.peek()!=ch) str.push(ch);
            else str.pop();
        }
        for(char ch:str) Adj+=ch;
        return Adj;
    }
}