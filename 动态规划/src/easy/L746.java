package easy;

/**
 *
 */
public class L746 {
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int prev= 0;
            int curr = 0;
            for (int i = 2; i < cost.length; i++) {
                int sum = Math.min(prev + cost[i - 1], curr + cost[i - 2]);
                prev = curr;
                curr = sum;
            }
            return curr;
        }
    }
}
