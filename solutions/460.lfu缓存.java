import java.util.*;
/*
 * @lc app=leetcode.cn id=460 lang=java
 *
 * [460] LFU缓存
 */

// @lc code=start
class LFUCache {
    Map<Integer, Node> cache;
    DLinkedList front;
    DLinkedList rear;
    int size;
    int capacity;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        front = new DLinkedList();
        rear = new DLinkedList();
        front.next = rear;
        rear.prev = front;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        visit(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            visit(node);
            return;
        }
        if (size == capacity) {
            cache.remove(rear.prev.tail.prev.key);
            rear.removeNode(rear.prev.tail.prev);
            size --;
            if (rear.prev.head.next == rear.prev.tail) {
                removeDLinkedList(rear.prev);
            }
        }
        node = new Node(key, value);
        cache.put(key, node);
        if (rear.prev.freq != 1) {
            DLinkedList dll = new DLinkedList(1);
            addDLinkedList(dll, rear.prev);
            dll.addNode(node);
        } else 
            rear.prev.addNode(node);
        size ++;
    }

    void visit(Node node) {
        DLinkedList dll = node.dll;
        DLinkedList prev = dll.prev;
        dll.removeNode(node);
        if (dll.head.next == dll.tail)
            removeDLinkedList(dll);
        node.freq ++;
        if (prev.freq != node.freq) {
            DLinkedList _dll = new DLinkedList(node.freq);
            addDLinkedList(_dll, prev);
            _dll.addNode(node);
        } else {
            prev.addNode(node);
        }
    }

    void addDLinkedList(DLinkedList curr, DLinkedList prev) {
        curr.next = prev.next;
        curr.next.prev = curr;
        curr.prev = prev;
        prev.next = curr;
    }

    void removeDLinkedList(DLinkedList curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    class Node {
        int key;
        int value;
        int freq = 1;
        Node prev;
        Node next;
        DLinkedList dll;

        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DLinkedList {
        int freq ;
        DLinkedList prev;
        DLinkedList next;
        Node head;
        Node tail;

        public DLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public DLinkedList(int freq) {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            this.freq = freq;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void addNode(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            node.dll = this;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

