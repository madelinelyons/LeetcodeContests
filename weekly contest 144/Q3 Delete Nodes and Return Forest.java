/*
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> toProcess = new ArrayList();
        toProcess.add(root);
        int processIndex = 0;
        
        List<TreeNode> 
        
        while(processIndex < toProcess.length){
            TreeNode current = toProcess[processIndex];
            while (current != null){
                for (int i = 0; i < to_delete.length; i++){
                    if(current.val == to_delete[i]){
                        if(current.left == null && current.right == null){
                            current.val = null;
                        }
                        else if(current.left != null){
                            toProcess.add(current.left);
                            current.val = null;
                        }
                        else if(current.right != null){
                            toProcess.add(current.right);
                            current.val = null;
                        }
                    }
                }
            processIndex++;
            }
        }
    
    }
    
}

// result: Not Accepted. need to study tree traversal again/better