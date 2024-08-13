class Solution {
    static void cs(int[] cand,int t,int idx,ArrayList<Integer> sl,List<List<Integer>> li){
        
        if(t==0){
            //if(!li.contains(sl)){
                li.add(new ArrayList<>(sl));
            //}
            
        }
        if(idx>=cand.length || t<0){
            return;
        }
        for(int i=idx;i<cand.length;i++){
            if(i>idx && cand[i]==cand[i-1]){
                continue;
            }
            if(t<cand[i]){
                break;
            }
            //if(cand[i]<=t){
                sl.add(cand[i]);
                cs(cand,t-cand[i],i+1,sl,li);
                sl.remove(sl.size()-1);
            //}
           
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> li = new ArrayList<>();
        ArrayList<Integer> sl = new ArrayList<>();
        Arrays.sort(candidates);
        cs(candidates,target,0,sl,li);
        return li;
    }
}