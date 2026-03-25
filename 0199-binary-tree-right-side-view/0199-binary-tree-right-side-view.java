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

    private void traverse(TreeNode root,int h,List<Integer>l)
    {
        if(root==null)
        return;
        if(l.size()==h)
        {
            l.add(root.val);
        }
        else
        {
            l.set(h,root.val);
        }
        traverse(root.left,h+1,l);
        traverse(root.right,h+1,l);
return;

    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        traverse(root,0,ans);
        return ans;
    }
}