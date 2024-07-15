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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashSet<Integer> childset = new HashSet<>();
        
        for(int i=0;i<descriptions.length;i++){
            int parentval = descriptions[i][0];
            int childval = descriptions[i][1];
            int isleft = descriptions[i][2];

            TreeNode parent = map.getOrDefault(parentval,new TreeNode(parentval));
            TreeNode child = map.getOrDefault(childval,new TreeNode(childval));

            if(isleft==1){
                parent.left = child;
            }
            else{
                parent.right = child;
            }

            map.put(parentval,parent);
            map.put(childval,child);

            childset.add(childval);
        }
        TreeNode root = null;
        for(int key : map.keySet()){
            if(!childset.contains(key)){
                root = map.get(key);
            }
        }
        return root;

    }
}