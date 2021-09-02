package medium;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : Create in 2021/9/2 上午 09:15
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : medium
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (judge(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    public boolean judge(TreeNode A, TreeNode B){
        if (B == null){
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return judge(A.left, B.left) || judge(A.right, B.right);
    }
}
