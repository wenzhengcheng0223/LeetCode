package easy;

import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: WenZhengcheng
 * @Date: 2022-6-13 上午 11:28
 * @Desc: 学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
 *
 * 排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
 *
 * 给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
 *
 * 返回满足 heights[i] != expected[i] 的 下标数量 。
 *
 */

public class L1051 {
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] expected = heights.clone();
        Arrays.sort(expected);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count ++;
            }
        }
        return count;
    }
}
