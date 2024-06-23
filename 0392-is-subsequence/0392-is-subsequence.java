class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()<1){
            return true;
        }
        int p1 = 0;
        int p2 = 0;
        while(p1<t.length() && p2<s.length()){
            if(t.charAt(p1)==s.charAt(p2)){
                p2++;
                if(p2==s.length()){
                    return true;
                }
            }
            p1++;
        }

        return false;
    }
}