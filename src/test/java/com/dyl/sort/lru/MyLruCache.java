package com.dyl.sort.lru;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 自己实现的一个简单的lru算法
 * lru算法，最近最久未使用，根据算法的原理，简单的来说可以通过一个
 * 1、双向链表实现
 * 2、HashMap+ 双线链表的实现
 * 3、直接通过linkedHashMap实现
 *
 * 本例用一个HashMap+双向链表实现
 *
 * @author dongyuliang
 * @date 2020-03-14 10:22
 */
public class MyLruCache<K,V> {

    private int currnetSize = 0;

    private int capacity;

    private Map<K,Node<K,V>> caches ;

    Node<K,V> head;

    Node<K,V> tail;

    public MyLruCache(int capacity) throws Exception {
        if(capacity <=0){
            throw new Exception();
        }
        this.capacity = capacity;
        caches = new HashMap<>();
    }

    public void put(K k,V v){

        Node<K, V> node = caches.get(k);
        if(node != null){
            node.setValue(v);
            moveToLast(node);
            return ;
        }
        if(currnetSize >= capacity){
            removeHead();
        }
        node = new Node<>(k,v);
        moveToLast(node);
        caches.put(k,node);
    }

    public V get(K k){
        Node<K, V> node = caches.get(k);
        if(node != null){
            moveToLast(node);
            return node.getValue();
        }
        return null;
    }

    public void moveToLast(Node<K,V> node){
        if(head == null || tail == null){
            head = tail = node;
            return;
        }
        if(node == tail){
            return;
        }
        if(node.before != null){
            node.before.after = node.after;
        }
        if(node.after != null){
            node.after.before = node.before;
        }
        if(node == head){
            head = node.after;
        }
        tail.after = node;
        node.before = tail;
        tail = node;
        node.after = null;
    }

    public void removeHead(){
        if(head != null){
            head.after.before = null;
            head = head.after;
            caches.remove(head.getKey());
        }
    }

    public Object remove(K k){
        Node<K, V> node = caches.get(k);
        if(node != null){
            if(node.before != null){
                node.before.after = node.after;
            }
            if(node.after != null){
                node.after.before = node.before;
            }
            if(node == head){
                head = node.after;
            }
            if(node == tail){
                tail = node.before;
            }
        }
        return caches.remove(k);
    }

    class Node<K,V>{
        K key;
        V value;
        Node before,after;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
