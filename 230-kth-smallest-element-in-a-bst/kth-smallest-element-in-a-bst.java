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
    int kk;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        kk = k;
        inorder(root);
        return result;
    }

    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        kk--;
        if(kk == 0)
        result = root.val;
        inorder(root.right);
    }
}