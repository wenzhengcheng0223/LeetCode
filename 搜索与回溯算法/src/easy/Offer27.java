package easy;

import medium.TreeNode;

import java.util.Stack;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/6 下午 02:34
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : easy
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode>stack = new Stack<>(){{add(root);}};
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
}
