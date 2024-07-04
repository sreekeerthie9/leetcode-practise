class Solution {
    public int partitionString(String s) {
        int arr[] = new int[26];
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a']==0){
                arr[s.charAt(i)-'a']++;
            }
            else{
                cnt++;
                Arrays.fill(arr,0);
                arr[s.charAt(i)-'a']++;
            }
        }
        cnt++;
        return cnt;
    }
}