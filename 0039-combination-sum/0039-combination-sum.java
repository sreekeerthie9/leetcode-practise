class Solution {
    static void fc(int[] candidates, int target,int idx,ArrayList<Integer> sl,List<List<Integer>> li){
        if(target==0){
            li.add(new ArrayList<>(sl));
            return;
        }
        if(idx>=candidates.length||target<0){
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(target>=candidates[i]){
                sl.add(candidates[i]);
                fc(candidates,target-candidates[i],i,sl,li);
                sl.remove(sl.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> li = new ArrayList<>();
        ArrayList<Integer> sl = new ArrayList<>();
        //HashMap<String,ArrayList<Integer>> map = new HashMap<>();
        fc(candidates,target,0,sl,li);
        return li;
    }
}