package com.azad.core.java.leetcodes.tutorials.queue_stack;

import java.util.HashMap;
import java.util.Map;
// linkedhashmap is suitable for lru cache Difference between HashMap and LinkedHashMap in Java | Java67
//explanation: https://www.youtube.com/watch?v=akFRa58Svug
// Note: Replace least recently use cache when new item doesnt exist in cache is to be added
// when cache window is full. Maintain order from least recently used -> most recently used from left to right
// when adding new item , remove the leftmost and shift everything to the left and add new item on the right 
// when requested item is on the left most side of cache , we move the item to the right
public class LRUCache_1 {
    public static void main(String[] args){

    }

    class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    class LRUCache {
        private Map<Integer,Node> map;
        // count = current size;
        // capacity = max size;
        private int capacity, count;
        private Node head, tail;

        public LRUCache(int _capacity){
            capacity = _capacity;
            map = new HashMap<>();
            head = new Node(0,0);
            tail = new Node(0,0);
            // set up empty head->tail nodes
            head.next = tail;
            tail.prev = head;
            head.prev = null;
            tail.next = null;
            count = 0;
        }
        // remove the node from being linked by anything
        public void deleteNode(Node node){
            /** 
             * from:
             * [node1] <-> [node2] <-> [node3]
             * to:
             * [node1] <-> [node3]
            */
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void addToHead(Node node){
            node.next = head.next;
            node.prev = head.prev;
            node.next.prev = node;
            head = node;
        }

        public void addToTail(Node node){
            node.prev = tail.prev;
            node.next = tail.next;
            tail.prev.next = node;
            tail = node;
        }

        // print out the state of map
        public void debug(){
            StringBuilder sb = new StringBuilder();
            for(Map.Entry<Integer,Node> entry : map.entrySet()){
                sb.append("[ " + entry.getKey() + ": " + entry.getValue() + " ] <-> ");
            }
            System.out.println(sb.toString());
        }

        public int get(int key){
            // if key is already cached move it to the tail
            if(map.containsKey(key)){
                Node node = map.get(key);
                int result = node.value;
                deleteNode(node);
                addToTail(node);
                debug();
            }
            return -1;
        }
    }
}

