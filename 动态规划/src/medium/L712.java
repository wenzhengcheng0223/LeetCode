package medium;

/**
 * 712. 两个字符串的最小ASCII删除和
 * 给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
 * 示例 1:
 *
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 *
 * dp[i,j]=(s1(0,i),s2(0,j)){
 *      s1(i)=s2(j): dp[i,j] = dp[i-1,j-1]
 *      s1(i)!=s2(j): dp[i,j] = min(dp[i-1,j]+s1(i),dp[i,j-1]+s2(j))
 * }
 *
 */
public class L712 {

    public int minimumDeleteSum(String s1, String s2) {
        int s1L = s1.length();
        int s2L = s2.length();
        int[][] dp = new int[s1L + 1][s2L + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= s1L; i++) {
            dp[i][0] = dp[i-1][0] + s1.codePointAt(i - 1);
        }
        for (int i = 1; i <= s2L; i++) {
            dp[0][i] = dp[0][i-1] + s2.codePointAt(i - 1);
        }
        for (int i = 1; i <= s1L; i++) {
            int i1 = s1.codePointAt(i - 1);
            for (int j = 1; j <= s2L; j++) {
                int i2 = s2.codePointAt(j - 1);
                if (i1 == i2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + i1, dp[i][j - 1] + i2);
                }
            }
        }
        return dp[s1L][s2L];
    }

}
