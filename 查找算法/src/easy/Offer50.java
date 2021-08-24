package easy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description : 剑指 Offer 50. 第一个只出现一次的字符
 * @Author : WenZhengcheng
 * @Date : Create in 2021/8/24 下午 06:37
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : easy
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        for (char ch:s.toCharArray()){
            map.put(ch,!map.containsKey(ch));
        }
        for (Map.Entry<Character, Boolean> ch:map.entrySet())
        {
            if(ch.getValue()) {
                return ch.getKey();
            }
        }
        return ' ';
    }
}
