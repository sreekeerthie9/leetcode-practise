class Solution {
    static void cp(String digits,String arr[],int idx,StringBuilder str,List<String> li){
        if(idx==digits.length()){
            li.add(str.toString());
            return;
        }
        //int dig = (digits.charAt(idx)-'0');
        //String s = arr[(digits.charAt(idx)-'0')];
        for(char ch:arr[(digits.charAt(idx)-'0')].toCharArray()){
            str.append(ch);
            cp(digits,arr,idx+1,str,li);
            str.deleteCharAt(str.length()-1);
            
        }

    }
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.isEmpty()){
            return new ArrayList<>();
        }
        String arr[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> li = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        cp(digits,arr,0,str,li);
        return li;
    }
}