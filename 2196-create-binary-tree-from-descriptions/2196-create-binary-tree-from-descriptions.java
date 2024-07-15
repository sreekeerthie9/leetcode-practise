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
        TreeNode tree[] = new TreeNode[100001];
        boolean child[] = new boolean[100001];

        
        for(int i=0;i<descriptions.length;i++){
            int parentval = descriptions[i][0];
            int childval = descriptions[i][1];
            int isleft = descriptions[i][2];

            if(tree[parentval]==null){
                tree[parentval] = new TreeNode(parentval);
            }
            if(tree[childval]==null){
                tree[childval] = new TreeNode(childval);
            }

            if(isleft==1){
                tree[parentval].left = tree[childval];
            }
            else{
                tree[parentval].right = tree[childval];
            }

            child[childval] = true;
           
        }
        TreeNode root = null;
        for(int[] des : descriptions){
            if(!child[des[0]]){
                root = tree[des[0]];
            }
        }
        return root;

    }
}