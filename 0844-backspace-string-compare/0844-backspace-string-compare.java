class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> str=new Stack<>();
        Stack<Character> qtr=new Stack<>();
        Compare(str,s);
        Compare(qtr,t);
        return str.equals(qtr);
    }

    public void Compare(Stack<Character> str,String s){
        for(char c:s.toCharArray()){
            if(c!='#') str.push(c);
             else if (!str.isEmpty()) {
                str.pop();
            }
        }
    }
}