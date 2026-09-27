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
    class Pair{
        TreeNode node;
        int parent;
        int depth;
        Pair(int p,TreeNode n,int d){
            this.node=n;
            this.parent=p;
            this.depth=d;
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
      if(root==null) return true;
      Queue<Pair> q=new LinkedList<>();
      q.offer(new Pair(-1,root,0));
      int xDepth=-1,yDepth=-1,xPar=-2,yPar=-2;
      while(!q.isEmpty()){
          int size=q.size();
          while(size-->0){
            Pair pair=q.poll();
            TreeNode cur=pair.node;
            int parent=pair.parent;
            int depth=pair.depth;
            if(x==cur.val){
                xDepth=depth;
                xPar=parent;
            }else if(y==cur.val){
                yDepth=depth;
                yPar=parent;
            }
            if(cur.left!=null){
                q.offer(new Pair(cur.val, cur.left, depth + 1));
            }
            if(cur.right!=null){
                q.offer(new Pair(cur.val, cur.right, depth + 1));
            }
          
          }
      }  
      if((xDepth!=yDepth) || (xPar==yPar)) return false;
      return true;
    }
}