class Solution {
    public int compress(char[] chars) {
        int length=chars.length;
        int index=0;
        int i=0;
        while(i<length){
            char char_ter= chars[i];
            int count=0;


            while(i<length && chars[i]==char_ter){
                count++;
                i++;
            }
            chars[index]=char_ter;
            index++;
            if(count>1){
                String Freq_Count = Integer.toString(count);
                for(char ch:Freq_Count.toCharArray()){
                    chars[index]=ch;
                    index++;
                }
            }
        }

        return index;
    }
}