package easy;

import java.util.HashSet;

/**
 * @Description : 剑指 Offer 03. 数组中重复的数字
 * @Author : WenZhengcheng
 * @Date : create in 2021-08-23 下午 05:14
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : easy
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */
public class Offer03 {

    class Solution {
        public int findRepeatNumber(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int number :
                    nums) {

                if (!set.add(number)){
                    return number;
                }
            }
            return -1;
        }
    }
}
