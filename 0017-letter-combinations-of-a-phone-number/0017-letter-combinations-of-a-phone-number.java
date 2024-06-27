class Solution {
    static void cp(String digits,String arr[],int idx,String str,List<String> li){
        if(idx==digits.length()){
            li.add(str);
            return;
        }
        for(char ch:arr[(digits.charAt(idx)-'0')].toCharArray()){
            
            cp(digits,arr,idx+1,str+ch,li);
            
        }

    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()<1){
            return new ArrayList<>();
        }
        String arr[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> li = new ArrayList<>();
        String str = "";
        cp(digits,arr,0,str,li);
        return li;
    }
}