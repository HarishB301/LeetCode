class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch:s.toCharArray()){
            boolean bool = Character.isUpperCase(ch);
            char a = Character.toLowerCase(ch);
            char b = Character.toUpperCase(ch);
            if(stack.isEmpty()) stack.push(ch);
            else if(bool && stack.peek()==a) stack.pop();
            else if(!bool && stack.peek()==b) stack.pop();
            else stack.push(ch);
        }
        String str="";
        for(char ch:stack) str+=ch;
        return str;
    }
}