package medium;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description : 剑指 Offer 32 - I. 从上到下打印二叉树
 *                从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * @Author : WenZhengcheng
 * @Date : Create in 2021/8/25 下午 10:39
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : easy
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */

/**
 * Definition for a binary tree node.
 * public class easy.TreeNode {
 *     int val;
 *     easy.TreeNode left;
 *     easy.TreeNode right;
 *     easy.TreeNode(int x) { val = x; }
 * }
 */
public class Offer32_1 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> que = new LinkedList<>(){{add(root);}};
        ArrayList<TreeNode> arr = new ArrayList<>();
        while (!que.isEmpty()){
            TreeNode node = que.poll();
            arr.add(node);
            if (node.left != null){
                que.add(node.left);
            }
            if (node.right != null){
                que.add(node.right);
            }
        }
        int[] ans = new int[arr.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = arr.get(i).val;
        }
        return ans;
    }
}
