/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        post(root,list);
        list.add(root.val);
        return list;
    }

    public void post(Node root,List<Integer> list ){
        if(root==null) return;
        for(Node node:root.children){
            post(node,list);
            list.add(node.val);
        }
    }
}