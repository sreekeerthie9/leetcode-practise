class Solution {
    public int largestCombination(int[] candidates) {
       int max = 0;
       int count[] = new int[32];
        for(int num : candidates){
            find(num,count);
        }

        for(int i=0;i<32;i++){
            max = Math.max(max, count[i]);
        }
        return max;
    }

    public void find(int num, int count[]){
        int j=31;

        while(num>0){
            int a = (num&1);
            count[j] +=a;
            num>>=1;
            j--;
        }
    }
}