package Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class LRUCache<K, V> implements Cache<K, V> {
    private ReentrantReadWriteLock reentrantReadWriteLock;
    private ReadLock rLock;
    private WriteLock wlock;

    private Map<K, Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    private class Node{
        K key;
        V val;
        Node prev;
        Node next;

        public Node(){
        }

        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(){
        initialize(100);
    }

    private void initialize(int capacity){
        reentrantReadWriteLock = new ReentrantReadWriteLock();
        rLock = reentrantReadWriteLock.readLock();
        wlock = reentrantReadWriteLock.writeLock();

        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }


    public LRUCache(int capacity) {
        initialize(capacity);
    }


    /**
     * if key, value exist:
     *      remove corresponding node from list and map
     *      insert new node  at list tail and map
     *
     * if key not exist: // need to add into the linkedlist
     *      if map is full:
     *          remove the oldest node from list and map
     *          insert new node into list tail and map
     *      if map not full:
     *          insert new node into list tail and map
     *
     * */
    @Override
    public void put(K key, V value) {
        wlock.lock();
        if (map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
        }else if (map.size() == capacity){
            removeNode(head.next);
        }
        insertIntoTail(new Node(key, value));
        wlock.unlock();
    }

    /**
     * if key not exist, return null
     * remove the Node corresponding to key, and append it at the tail
     *
     * */
    @Override
    public V get(K key) {
        rLock.lock();
        if (!map.containsKey(key)){
            return null;
        }
        Node node = map.get(key);
        rLock.unlock();

        wlock.lock();
        removeNode(node);
        insertIntoTail(node);
        wlock.unlock();
        return node.val;
    }

    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        map.remove(node.key);
    }

    private void insertIntoTail(Node node){
        Node prevTail = tail.prev;
        prevTail.next = node;
        node.prev = prevTail;
        node.next = tail;
        tail.prev = node;
        map.put(node.key, node);
    }
}
