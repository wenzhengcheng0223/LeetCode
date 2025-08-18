package medium;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * x-y是回文子串
 * dp[x,y]=dp[x+1,y-1] && str[x]==str[y]
 */
public class L5 {
    public static String longestPalindrome(String s) {
        int maxLen = 1;
        int begin = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int l = 2; l <= len; l++) {
            for (int left = 0; left < len; left++) {
                // 右边界
                int right = l + left - 1;
                if (right >= len) {
                    break;
                }
                if (charArray[left] != charArray[right]) {
                    dp[left][right] = false;
                } else {
                    if (right - left < 3) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }
                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    begin = left;
                }

            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
