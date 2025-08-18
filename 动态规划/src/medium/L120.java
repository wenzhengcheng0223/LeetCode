package medium;

import java.util.List;

/**
 *给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * 自底向上构建状态转移方程
 * dp[i][j] = min(dp[i+1][j],dp[i+1][j+1]) + triangle[i][j]
 */
public class L120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.getLast().size();
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                if (i == m -1) {
                    dp[i][j] = triangle.get(i).get(j);
                    continue;
                }
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(minimumTotal(List.of(List.of(2),List.of(3,4),List.of(6,5,7),List.of(4,1,8,3))));
    }
}
