package easy;

/**
 * @Description :
 * @Author : WenZhengcheng
 * @Date : create in 2021-08-22 下午 02:22
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : easy
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */
public class Offer58 {
    class Solution {
        /**
         * 列表遍历拼接
         * @param s
         * @param n
         * @return
         */
        public String reverseLeftWords(String s, int n) {
            if(n == 0){
                return s;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = n; i < s.length(); i++) {
                stringBuilder.append(s.charAt(i));
            }
            for (int i = 0;i <n;i++){
                stringBuilder.append(s.charAt(i));
            }
            return stringBuilder.toString();
        }

        /**
         * 切片
         * @param s
         * @param n
         * @return
         */
        public String reverseLeftWords1(String s, int n) {

            return s.substring(n)+s.substring(0, n);
        }
    }
}
