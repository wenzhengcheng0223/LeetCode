package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 1218. 最长定差子序列
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 *
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 */
public class L1218 {
    public static int longestSubsequence(int[] arr, int difference) {
        int maxL = 1;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : arr) {
            Integer orDefault = map.getOrDefault(num - difference, 0);
            map.put(num, orDefault+1);
            maxL = Math.max(maxL, orDefault + 1);
        }

        return maxL;
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{1,2,3,4}, 1));
    }
}
