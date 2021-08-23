package easy;

/**
 * @Description : 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * @Author : WenZhengcheng
 * @Date : create in 2021-08-23 下午 07:14
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : easy
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */

public class Offer53 {
    class Solution {
        public int search(int[] nums, int target) {
            int i = 0, j = nums.length-1;
            while (i <= j){
                int mid = (i + j)/2;
                if(nums[mid] <= target){
                    i = mid + 1;
                }else{
                    j = mid - 1;
                }
            }
            int right = i;
            i = 0;
            j = nums.length;
            while (i <= j){
                int mid = (i + j)/2;
                if (nums[mid] < target){
                    i = mid + 1;
                }
                else{
                    j = mid - 1;
                }
            }
            int left = j;

            return right - left -1;
//            [5,7,7,8,8,10]
//            8
//            运用两次二分查找，第一次找到target的右边界也就是10的下表，第二次找到target-1 也就是7的
//            return binarySearch(nums, target) - binarySearch(nums, target-1);
        }

    }
    public static int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (left + right)/2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,3,3,4,5,6,7,8,8,8,9,10};
        int index = binarySearch(nums, 2);
        System.out.println(index);
    }
}
