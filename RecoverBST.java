// https://leetcode.com/problems/recover-binary-search-tree/

// Time Complexity: O(n)
// Space Complexity: O(h) or O(log n) depending on the balance of the tree.

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
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        //base
        if(root == null) return;

        //logic
        inorder(root.left);

        if(prev != null && prev.val >= root.val) {
            //first
            if(first == null) {
                first = root;
                second = prev;
            } else {
                first = root;
            }
        }

        prev = root;

        inorder(root.right);
    }
}
