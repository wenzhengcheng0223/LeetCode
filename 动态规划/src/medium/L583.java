package medium;

/**
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 *
 * 每步 可以删除任意一个字符串中的一个字符。
 *
 * dp[i,j] = (s1[0,i],s2[0,j]){
 *     s1(i) = s2(j): dp[i][j] = dp[i-1][j-1]
 *     s1(i) != s2(j): dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + 1;
 * }
 */
public class L583 {


    public static int minDistance(String word1, String word2) {
        int s1L = word1.length();
        int s2L = word2.length();
        int[][] dp = new int[s1L + 1][s2L + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= s1L; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= s2L; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= s1L; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= s2L; j++) {
                char c2 = word2.charAt(j - 1);
                dp[i][j] = c1 == c2 ? dp[i - 1][j - 1] : (Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
            }
        }
        return dp[s1L][s2L];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("a","b"));
    }

}
