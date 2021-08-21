package easy;

import java.util.Stack;

/**
 * @Description : 剑指 Offer 06. 从尾到头打印链表
 * @Author : WenZhengcheng
 * @Date : create in 2021-08-21 下午 01:16
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : easy
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */
public class Offer06 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }
    class Solution {
        public int[] reversePrint(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            while (head != null){
                stack.push(head.val);
                head = head.next;
            }
            int[] value = new int[stack.size()];
            for (int i = 0; i < value.length; i++) {
                value[i] = stack.pop();
            }
            return value;
        }
    }
}
