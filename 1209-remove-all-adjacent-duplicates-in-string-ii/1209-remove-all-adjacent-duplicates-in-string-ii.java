class Solution {
    public String removeDuplicates(String s, int k) {
       Stack<int[]> stack = new Stack<>();

       for(char ch:s.toCharArray()){
          if(!stack.isEmpty() && stack.peek()[0]==ch){
            stack.peek()[1]++;
            if(stack.peek()[1]==k) stack.pop();
          }else stack.push(new int[]{ch,1});
       }

       StringBuilder str=new StringBuilder();
       for(int[] arr:stack){
        char ch=(char)arr[0];
        int count = arr[1];
            while(count>0){
                str.append(ch);
                count--;
            }
       }
        return str.toString();
    }

    
}