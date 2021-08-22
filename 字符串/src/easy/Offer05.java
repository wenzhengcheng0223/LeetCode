package easy;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : create in 2021-08-22 下午 02:18
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : easy
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */
public class Offer05 {
    class Solution {
        public String replaceSpace(String s) {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)==' '){
                    buffer.append("%20");
                }else {
                    buffer.append(s.charAt(i));
                }
            }
            return buffer.toString();

        }
    }

}
