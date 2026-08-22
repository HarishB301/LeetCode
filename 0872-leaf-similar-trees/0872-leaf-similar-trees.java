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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return true;
        List<Integer> list1=new ArrayList<>(); 
        List<Integer> list2=new ArrayList<>();
        helper(list1,root1);
        helper(list2,root2);
        return list1.equals(list2);
        
    }
    public void helper(List<Integer> list,TreeNode root){
        if(isLeaf(root)){
            list.add(root.val);
            return;
        }
        if(root.left!=null)  helper(list,root.left);
        if(root.right!=null) helper(list,root.right);
    }

    public boolean isLeaf(TreeNode r){
        if(r.left==null && r.right==null) return true;
        return false;
    }
}