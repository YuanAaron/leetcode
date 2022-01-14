package datastructure.manhuasuanfa.algorithmApplication;

import java.util.Comparator;

public class SkipList<T> {
    public static void main(String[] args) {

    }

    Comparator<T> comparator;
    headIndex<T> head;

    public T get(T value) {
        if (value == null) {
            throw new NullPointerException();
        }

        // 【第一大步】：先找到前置的索引节点


        // 【第二大步】：再按照链表的方式查找
    }

    private Node<T> findPreIndexNode(T value, boolean contain) {
        // 从头节点开始查找，规律是先往右再向下，再往右再向下
        Index<T> q = this.head;
        Index<T> r,d;
        Comparator<T> cmp = this.comparator;
        for (;;) {

        }
    }

    /**
     * 头节点：标记层
     * @param <T>
     */
    private static class headIndex<T> extends Index<T> {
        int level; //层级
        
        public headIndex(Node<T> node, Index<T> down, Index<T> right, int level) {
            super(node, down, right);
            this.level = level;
        }
    }

    /**
     * 索引节点：引用着真实节点
     * @param <T>
     */
    private static class Index<T> {
        Node<T> node; //真实节点
        Index<T> down; //下指针（第一层的索引实际上是没有下指针的）
        Index<T> right; //右指针

        public Index(Node<T> node, Index<T> down, Index<T> right) {
            this.node = node;
            this.down = down;
            this.right = right;
        }
    }

    /**
     * 链表节点（真正存储数据的节点）
     * @param <T>
     */
    private static class Node<T> {
        T value; //节点元素值
        Node<T> next; //下一个节点

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return value == null ? "h0" : value.toString() + "->" + (next == null ? "null" :next.toString());
        }
    }



}
