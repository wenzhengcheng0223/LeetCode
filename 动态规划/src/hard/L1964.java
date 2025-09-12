package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1964. 找出到每个位置为止最长的有效障碍赛跑路线
 * 你打算构建一些障碍赛跑路线。给你一个 下标从 0 开始 的整数数组 obstacles ，数组长度为 n ，其中 obstacles[i] 表示第 i 个障碍的高度。
 * <p>
 * 对于每个介于 0 和 n - 1 之间（包含 0 和 n - 1）的下标  i ，在满足下述条件的前提下，请你找出 obstacles 能构成的最长障碍路线的长度：
 * <p>
 * 你可以选择下标介于 0 到 i 之间（包含 0 和 i）的任意个障碍。
 * 在这条路线中，必须包含第 i 个障碍。
 * 你必须按障碍在 obstacles 中的 出现顺序 布置这些障碍。
 * 除第一个障碍外，路线中每个障碍的高度都必须和前一个障碍 相同 或者 更高 。
 * 返回长度为 n 的答案数组 ans ，其中 ans[i] 是上面所述的下标 i 对应的最长障碍赛跑路线的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：obstacles = [1,2,3,2]
 * 输出：[1,2,3,3]
 * 解释：每个位置的最长有效障碍路线是：
 * - i = 0: [1], [1] 长度为 1
 * - i = 1: [1,2], [1,2] 长度为 2
 * - i = 2: [1,2,3], [1,2,3] 长度为 3
 * - i = 3: [1,2,3,2], [1,2,2] 长度为 3
 * <p>
 * dp[i] = dp[i-1] + obs[i]>obs[i-1]? 1 : 0
 */
public class L1964 {

    public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        if (obstacles.length == 1) {
            return new int[]{1};
        }
        int[] dp = new int[obstacles.length];
        for (int i = 0; i < obstacles.length; i++) {
            dp[i] = 1;
        }
        List<Integer> list = new ArrayList<>();
        list.add(obstacles[0]);
        for (int i = 1; i < obstacles.length; i++) {

            if (list.getLast()<=obstacles[i]) {
                list.add(obstacles[i]);
                dp[i] = list.size();
            } else {
                int l = 0, r = list.size() - 1;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (list.get(mid) > obstacles[i]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                list.set(l, obstacles[i]);
                dp[i] = l+1;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(longestObstacleCourseAtEachPosition(new int[]{1, 2, 3, 2})));
        System.out.println(Arrays.toString(longestObstacleCourseAtEachPosition(new int[]{3, 1, 5, 6, 4, 2})));
        System.out.println(Arrays.toString(longestObstacleCourseAtEachPosition(new int[]{5, 1, 5, 5, 1, 3, 4, 5, 1, 4})));
    }

}
