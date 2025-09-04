package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 */
public class LRUCache {

    private Node head,tail;

    private final int capacity;
    private int size = 0;
    private final Map<Integer, Node> cache = new HashMap<>();




    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    // head node tail
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    // head node tail
    private void addHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 移动node到链头
        removeNode(node);
        addHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            addHead(node);
            return;
        }
        if (capacity < size + 1) {
            // 淘汰
            cache.remove(tail.prev.key);
            removeNode(tail.prev);
            size --;
        }
        Node node = new Node(key, value);
        addHead(node);
        cache.put(key, node);
        size++;
    }

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(){}
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        //["LRUCache","put","put","put","put","get","get"]
        // [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));


    }

}
