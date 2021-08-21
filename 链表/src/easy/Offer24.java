package easy;

/**
 * @Description : 剑指 Offer 24. 反转链表
 * @Author : WenZhengcheng
 * @Date : create in 2021-08-21 下午 02:25
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : easy
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */
public class Offer24 {
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
        public ListNode reverseList(ListNode head) {
            ListNode pre = null, temp = null, value = head;
            while(value != null){
                temp = value.next;
                value.next = pre;
                pre = value;
                value = temp;
            }
            value = pre;
            return value;
        }
    }
}
