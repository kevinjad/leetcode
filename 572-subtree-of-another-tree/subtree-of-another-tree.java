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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        return compare(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public boolean compare(TreeNode root, TreeNode subRoot){
        if(root == null || subRoot == null){
            return root == subRoot;
        }
        if(root.val == subRoot.val){
            return compare(root.left, subRoot.left) && compare(root.right, subRoot.right);
        } else return false;
    }
}