package easy;

/**
 * @Description : 剑指 Offer 11. 旋转数组的最小数字
 * @Author : WenZhengcheng
 * @Date : Create in 2021/8/24 下午 04:31
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : easy
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */
public class Offer11 {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (numbers[mid] > numbers[right]){
                left = mid + 1;
            }else if (numbers[mid] < numbers[right]){
                right = mid;
            }else {
                right --;
            }
        }
        return numbers[left];
    }
}
