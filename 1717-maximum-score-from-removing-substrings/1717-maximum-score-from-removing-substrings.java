class Solution {
    public int maximumGain(String s, int x, int y) {
        String top,bot;
        int top_score;
        int bot_score;
        int res = 0;
        if(x>y){
           top = "ab";
           top_score = x;
           bot = "ba";
           bot_score = y;
        }
        else{
            top = "ba";
            top_score = y;
            bot = "ab";
            bot_score = x;
        }

        

        StringBuilder stack = new StringBuilder();
        for(char ch : s.toCharArray()){
             if(ch==top.charAt(1) && stack.length()>0 && stack.charAt(stack.length()-1)==top.charAt(0)){
                res+=top_score;
                stack.setLength(stack.length()-1);
             }
             else{
                stack.append(ch);
             }
        }
        StringBuilder stack2 = new StringBuilder();
        for(char ch : stack.toString().toCharArray()){
             if(ch==bot.charAt(1) && stack2.length()>0 && stack2.charAt(stack2.length()-1)==bot.charAt(0)){
                res+=bot_score;
                stack2.setLength(stack2.length()-1);
             }
             else{
                stack2.append(ch);
             }
        }

        return res;
    }
}