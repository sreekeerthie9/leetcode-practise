class Solution {
    static void cp(String digits,String arr[],int idx,String str,List<String> li){
        if(idx==digits.length()){
            li.add(str);
            return;
        }
        int dig = (digits.charAt(idx)-'0');
        String s = arr[dig];
        for(char ch:s.toCharArray()){
            
            cp(digits,arr,idx+1,str+ch,li);
            
        }

    }
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.isEmpty()){
            return new ArrayList<>();
        }
        String arr[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> li = new ArrayList<>();
        String str = "";
        cp(digits,arr,0,str,li);
        return li;
    }
}