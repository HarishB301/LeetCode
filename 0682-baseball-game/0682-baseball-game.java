class Solution {
    public int calPoints(String[] str) {
        Stack<Integer> s = new Stack<>();
        int sum=0;
        for(String ch:str){
            if(ch.equals("C")) s.pop();
            else if(ch.equals("D")){
                int last = s.peek();
                s.push(last*2);
            }else if(ch.equals("+")){
                int a = s.pop();
                int b= s.peek();
                s.push(a);
                s.push(a+b);
            }else{
                int n = Integer.parseInt(ch);
                s.push(n);
            }
        }
        while (!s.isEmpty()) {
            sum += s.pop();
        }

        return sum;
    }
}