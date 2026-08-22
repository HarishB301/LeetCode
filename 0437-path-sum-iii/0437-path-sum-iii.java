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
    public int pathSum(TreeNode root, int target) {
        if(root==null) return 0;
        return helper(root,target);
    }
    public int helper(TreeNode root,int target){
        if(root==null) return 0;
        int count= pathsum(root,(long)target);
         count+=helper(root.left,target);
         count+=helper(root.right,target);
        return count;
    }

    public int pathsum(TreeNode root,long target){
        if(root==null) return 0;
        target-=root.val;
        int count=0;
        if(target==0) count=1;
        count+=pathsum(root.left,target);
        count+=pathsum(root.right,target); 
        return count;
    }
}