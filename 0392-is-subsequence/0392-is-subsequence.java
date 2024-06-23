class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()){
            return false;
        }
        int p1 = 0;
        int p2 = 0;
        while(p1<t.length() && p2<s.length()){
            if(t.charAt(p1)==s.charAt(p2)){
                p2++;
            }
            p1++;
        }

        return (p2==s.length());
    }
}