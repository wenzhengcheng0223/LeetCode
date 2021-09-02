package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/2 上午 08:48
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : medium
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */
public class Offer32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size()%2 == 0) {
                    temp.addLast(node.val);
                }else{
                    temp.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
