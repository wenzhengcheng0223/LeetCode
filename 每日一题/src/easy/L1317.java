package easy;

import java.util.Random;

/**
 * 1317. 将整数转换为两个无零整数的和
 * 「无零整数」是十进制表示中 不含任何 0 的正整数。
 *
 * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [a, b]，满足：
 *
 * a 和 b 都是无零整数
 * a + b = n
 * 题目数据保证至少有一个有效的解决方案。
 *
 * 如果存在多个有效解决方案，你可以返回其中任意一个。
 */
public class L1317 {
    public int[] getNoZeroIntegers(int n) {
        if(n ==2 ){
            return new int[]{1,1};
        }
        if(n== 10000){
            return new int[]{1,9999};
        }
        int[] res = new int[2];
        Random random = new Random();
        for(int i=1;i<10000;i++){
            int a = random.nextInt(n - 1) + 1;
            if (!Integer.toString(a).contains("0") && !Integer.toString(n - a).contains("0")) {
                return new int[]{a, n - a};
            }
        }



        return res;
    }
}
