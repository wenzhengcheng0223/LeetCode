package medium;

/**
 * 72. 编辑距离
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * d[i][j] =  s1[i] = s2[j]? min(d[i-1][j]+1,d[i][j-1]+1,d[i-1][j-1]: min(d[i-1][j]+1,d[i][j-1]+1,d[i-1][j-1]+1)
 * i= s1的前i个字符
 * j= s2的前j个字符
 */
public class L72 {
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length()+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length()+1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < word1.length()+1; i++) {
            for (int j = 1; j < word2.length()+1; j++) {
                int a = dp[i - 1][j] + 1;
                int b = dp[i][j - 1] + 1;
                int c = dp[i - 1][j - 1];
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    c +=1;
                }
                dp[i][j] = Math.min(a, Math.min(b, c));
            }

        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
    }
}
