package easy;

import medium.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description : 新增 剑指 Offer 28. 对称的二叉树 迭代法
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/6 下午 03:08
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : easy
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */
public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root.left);
        que.add(root.right);
        while (!que.isEmpty()){
            TreeNode leftNode = que.poll();
            TreeNode rightNode = que.poll();
            if (leftNode == null &&rightNode == null) {
                continue;
            }
            else if (leftNode == null || rightNode == null || (leftNode.val != rightNode.val)){
                return false;
            }
            que.add(leftNode.left);
            que.add(rightNode.right);
            que.add(leftNode.right);
            que.add(rightNode.left);
        }
        return true;
    }
}
