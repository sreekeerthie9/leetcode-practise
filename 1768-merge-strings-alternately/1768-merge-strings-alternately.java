class Solution {
    public String mergeAlternately(String word1, String word2) {
        String str = "";
        int i=0;
        int j=0;
        for(i=0,j=0;i<word1.length()&&j<word2.length();i++,j++){
            str+=word1.charAt(i);
            str+=word2.charAt(j);
        }
        while(i<word1.length()){
            str+=word1.charAt(i);
            i++;
        }
        while(j<word2.length()){
            str+=word2.charAt(j);
            j++;
        }
        return str;
    }
}