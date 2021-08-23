package easy;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : create in 2021/8/23 下午 08:43
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : IntelliJ IDEA
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */

public class Offer53_2 {

    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

}
