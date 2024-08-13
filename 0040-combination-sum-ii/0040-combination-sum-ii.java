class Solution {
    private static void cs(int[] candidates,int idx,int sum,int target,ArrayList<Integer> li,List<List<Integer>> al){
        
        if(target==sum){
            al.add(new ArrayList<>(li));
            return;
        }
        if(idx>=candidates.length){
            return;
        }
           
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]){
                continue;
            }
            if(sum>target){
                continue;
            }
            li.add(candidates[i]);
            cs(candidates,i+1,sum+candidates[i],target,li,al);
            li.remove(li.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> al = new ArrayList<>();
        ArrayList<Integer> li = new ArrayList<>();
        Arrays.sort(candidates);
        cs(candidates,0,0,target,li,al);
        return al;
    }
}