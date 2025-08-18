package medium;

/**
 *1780. 判断一个数字是否可以表示成三的幂的和
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 *
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
 */
public class L1780 {
    public static boolean checkPowersOfThree(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < n; i++) {
            int pow3 = (int) Math.pow(3,i);
            if (pow3 > n) {
                break;
            }
            for (int j = n; j >= pow3; j--) {
                dp[j] = dp[j - pow3];
            }
        }
        return dp[n] > 0;
    }

    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(12));
    }
}
