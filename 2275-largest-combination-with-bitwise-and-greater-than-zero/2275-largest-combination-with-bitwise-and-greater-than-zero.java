class Solution {
    public int largestCombination(int[] candidates) {
        int[] count = new int[32];
        for(int i=0;i<32;i++){
            for(int num : candidates){
                if((num & (1<<i))!=0){
                    count[i]++;
                }
            }
        }

        int max = 0;
        for(int c : count){
            if(c>max){
                max = c;
            }
        }
        return max;
    }
}