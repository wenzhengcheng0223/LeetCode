package medium;

/**
 * @Description : 剑指 Offer 04. 二维数组中的查找
 * @Author : WenZhengcheng
 * @Date : create in 2021/8/24 下午 03:04
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : IntelliJ IDEA
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[]nums:matrix
             ) {
            if (binarySearch(nums, target)){
                return true;
            }
        }
        return false;
    }
    public boolean binarySearch(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return true;
            }
            if (nums[mid]<target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
