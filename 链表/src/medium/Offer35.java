package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :剑指 Offer 35. 复杂链表的复制
 * @Author : WenZhengcheng
 * @Date : create in 2021-08-21 下午 02:35
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : medium
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */
public class Offer35 {

// Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 利用键值对存储原有节点和新节点，把所有原始节点都存储完成后，
     * 重新指向head节点，然后构建新节点的next指针和random指针，
     * 因为所有的节点都已经重新创建好了，所以不会存在节点不存在的结果。
     */
    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node,Node>  map = new HashMap<>();
            Node cur = head;
            while (cur != null){
                map.put(cur, new Node(cur.val));
                 cur = cur.next;
            }
            cur = head;
            while (cur != null){
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            return map.get(head);
        }
    }
}
