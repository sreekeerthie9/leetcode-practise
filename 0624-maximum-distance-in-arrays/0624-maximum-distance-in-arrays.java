class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int secmin = Integer.MAX_VALUE;
        int secmax = Integer.MIN_VALUE;
        int minidx = -1;
        int maxidx = -1;
        int dist =0;

        for(int i=0;i<arrays.size();i++){
            int currmin = arrays.get(i).get(0);
            int currmax = arrays.get(i).get(arrays.get(i).size()-1);
            if(min>currmin){
                secmin = min;
                min = currmin;
                minidx = i;
            }
            else if(secmin>currmin){
                secmin = currmin;
            }
            if(max<currmax){
                secmax = max;
                max = currmax;
                maxidx = i;
            }
            else if(secmax<currmax){
                secmax = currmax;
            }
        }
        return minidx==maxidx?Math.max(secmax-min,max-secmin):max-min;
    }
}