class Solution {
    private boolean dfs(ArrayList<ArrayList<Integer>> G,int s,int d,boolean[] vis){
        if(s==d){
            return true;
        }
        vis[s] = true;
        for(int n : G.get(s)){
            if(n==d){
                return true;
            }
            if(!vis[n] && dfs(G,n,d,vis)){
                return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> G = new ArrayList<>();
        for(int i=0;i<n;i++){
            G.add(new ArrayList<>());
        }
        boolean vis[] = new boolean[n];
        for(int i=0;i<edges.length;i++){
            G.get(edges[i][0]).add(edges[i][1]);
            G.get(edges[i][1]).add(edges[i][0]);
        }
        return dfs(G,source,destination,vis);
    }
}