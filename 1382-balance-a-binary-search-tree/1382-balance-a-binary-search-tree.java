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
    static TreeNode buildbbst(ArrayList<Integer> li,int start,int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(li.get(mid));
        node.left = buildbbst(li,start,mid-1);
        node.right = buildbbst(li,mid+1,end);
        return node;
    }
    static void inorder(TreeNode root,ArrayList<Integer> li){
        if(root==null){
            return;
        }
        inorder(root.left,li);
        li.add(root.val);
        inorder(root.right,li);
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> li = new ArrayList<>();
        inorder(root,li);
        root = buildbbst(li,0,li.size()-1);
        return root;
    }
}