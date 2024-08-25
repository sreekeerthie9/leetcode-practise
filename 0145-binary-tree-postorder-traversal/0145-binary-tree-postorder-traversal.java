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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        preorder(root,li);
        return li;
    }
    private void preorder(TreeNode root , List<Integer> li){
        if(root==null){
            return;
        }
        
        preorder(root.left,li);
        preorder(root.right,li);
        li.add(root.val);
    }
}