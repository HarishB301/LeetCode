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
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        List<List<Integer>> list =new ArrayList<>();
        helper(list,root,new ArrayList<>());
        int maxSum=0;
        for(List<Integer> res:list){
            String str="";
            for(int num:res){
                str=str+Integer.toString(num);
            }
            maxSum+=Integer.parseInt(str);
        }
        return maxSum;
    }

    public void helper(List<List<Integer>> list,TreeNode root,List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        if(root.left==null && root.right==null){
            list.add(new ArrayList<>(res));
        }else{
            helper(list,root.left,res);
            helper(list,root.right,res);
        }
        res.remove(res.size()-1);
        
        
    }
}