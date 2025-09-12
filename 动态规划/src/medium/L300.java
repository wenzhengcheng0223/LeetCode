package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * <p>
 * [4,10,4,3,8,9]
 * dp[i]：以nums[i]结尾的，判断 nums[i]>nums[j] :max(dp[i],dp[j]+1)
 */
public class L300 {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int maxLen = 1;
        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);

        }
        return maxLen;
    }

    // 二分搜索+贪心
    public int lengthOfLISByBinarySearch(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.getLast()) {
                list.add(nums[i]);
            } else {
                int l=0,r=list.size()-1;
                while (l <= r) {
                    int mid = (l+r)/2;
                    if (list.get(mid) <= nums[i]) {
                        l = mid + 1;
                    } else {
                        r = mid -1;
                    }
                }
                list.set(l, nums[i]);
            }
        }
        return list.size();
    }

}
