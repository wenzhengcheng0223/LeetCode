package medium;

/**
 * 1027. 最长等差数列
 * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
 *
 * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... < ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的
 * 示例 1：
 *
 * 输入：nums = [3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * 2 <= nums.length <= 1000
 * 0 <= nums[i] <= 500
 */
public class L1027 {

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int d = 1001, max = 0;
        int[][] dp = new int[n][d];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 公差
                int temp = nums[i] - nums[j] + 500;
                dp[i][temp] = dp[j][temp] + 1;
                max = Math.max(max, dp[i][temp]);
            }
        }

        return max + 1;
    }
}
