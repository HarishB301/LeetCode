class Solution {
    public List<String> letterCombinations(String digits) {
        String nums[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> list = new ArrayList<>();
        letter(nums,list,0,new StringBuilder(),digits);
        return list;
    }

    public void letter(String nums[],List<String> list ,int index,StringBuilder str,String digits){
        if(index==digits.length()){
            list.add(str.toString());
            return;
        }
        char ch=digits.charAt(index);
        int num =Character.getNumericValue(ch);
        for(int i=0;i<nums[num].length();i++){
            str.append(nums[num].charAt(i));
            letter(nums,list,index+1,str,digits);
            str.deleteCharAt(str.length()-1);
        }
    }
}