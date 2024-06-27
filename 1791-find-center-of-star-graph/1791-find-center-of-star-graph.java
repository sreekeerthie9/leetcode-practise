class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length+1;
        ArrayList<ArrayList<Integer>> adg = new ArrayList<>();
        for(int i=0;i<n;i++){
            adg.add(new ArrayList<Integer>());
        }
        for(int[] ed : edges){
            adg.get(ed[0]-1).add(ed[1]-1);
            adg.get(ed[1]-1).add(ed[0]-1);
        }

        for(int i=0;i<adg.size();i++){
            if(adg.get(i).size()==n-1){
                return i+1;
            }
        }
        return -1;
        
    }
}