package easy;

import medium.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/8/31 下午 04:55
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : easy
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */
public class Offer32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }
}
