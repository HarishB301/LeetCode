class Solution {
    public String decodeString(String str) {
        Stack<String> CharStack = new Stack<>();
        Stack<Integer> CountStack = new Stack<>();
        int count=0;
        String current="";
        for(char ch:str.toCharArray()){
            if(Character.isDigit(ch)){
                count=count*10+(ch-'0');
            }else if(ch=='['){
                CountStack.push(count);
                CharStack.push(current);
                count=0;
                current="";
                
            }else if(ch==']'){
                int repeat = CountStack.pop();
                String preChar = CharStack.pop();
                StringBuilder string=new StringBuilder(preChar);
                while(repeat-->0) string.append(current);
                current=string.toString();
            }else{
                current+=ch;
            }
        }

        return current;
       
    }
  
}