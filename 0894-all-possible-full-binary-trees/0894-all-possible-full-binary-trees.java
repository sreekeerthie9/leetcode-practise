/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    static List<TreeNode> bt(int n, Map<Integer,List<TreeNode>> map){
        List<TreeNode> li = new ArrayList<>();
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n>0){
            if(n==1){
                li.add(new TreeNode(0));
            }
            else if(n==3){
                li.add(new TreeNode(0,new TreeNode(0),new TreeNode(0)));
            }
            else{
                for(int i=0;i<n;i++){
                    int j = n-i-1;
                    List<TreeNode> left = bt(i,map);
                    List<TreeNode> right = bt(j,map);
                    for(TreeNode lnode : left){
                        for(TreeNode rnode : right){
                            li.add(new TreeNode(0,lnode,rnode));
                        }
                    }
                }
            }
            map.put(n,li);
        
        }
        return li;
    }

    public List<TreeNode> allPossibleFBT(int n) {
        Map<Integer,List<TreeNode>> map = new HashMap<>();
        
        return bt(n,map);
    }
}