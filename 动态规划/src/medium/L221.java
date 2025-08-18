package medium;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * dp[x][y] = dp[x-1][y]+dp[x]
 */
public class L221 {

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        if (row == 1 && column == 1) {
            return matrix[0][0] == '1' ? 1 : 0;
        }
        int[][] dp = new int[row][column];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    dp[i][j] = matrix[i][j] == '1' ? Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1 : 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

}
