package basic;

/**
 * @author yw
 */
public class ThirdHashMap<K, V> {

    //------------------成员变量----------------

    /**
     * 默认容量
     */
    final int DEFAULT_CAPACITY = 16;

    /**
     * 负载因子
     */
    final float LOAD_FACTOR = 0.75f;

    /**
     * 桶数组
     */
    Node<K,V>[] buckets;

    /**
     * HashMap的大小
     */
    private int size;

    //--------------------构造方法----------------

    public ThirdHashMap() {
        this.buckets = new Node[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ThirdHashMap(int capacity) {
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    //---------------------内部节点类-------------------

    /**
     * 内部节点类
     * @param <K>
     * @param <V>
     */
    class Node<K, V> {

        // 键值对
        private K key;
        private V value;

        // 链表，后继
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // -----------------散列函数----------------

    private int getIndex(K key, int length) {
        // 获取hash code
        int hashCode = hashCode(key);
        // 和桶数组长度取余(index可能为负)
        int index = hashCode % length;
        return Math.abs(index);
    }

    private int hashCode(K key) {
        return key == null ? 0 : key.hashCode();
    }

    // -----------------put方法------------------

    public void put(K key, V value) {
        // 判断是否需要进行扩容
        if (this.size >= this.buckets.length * this.LOAD_FACTOR) {
            resize();
        }
        putVal(key,value,this.buckets);
    }

    /**
     * 将元素存入指定的Node数组（put和resize方法都会调用该方法）
     * 1. 获取元素插入位置
     *    2. 如果该位置为空，直接插入；
     *    3. 如果该位置不为空，即发生了冲突，遍历链表。
     *       4. 如果待插入的元素key和节点相同，用新的value值覆盖旧的；
     *       5. 否则，新建节点并插入链表头部
     * @param key
     * @param value
     * @param table
     */
    private void putVal(K key, V value, Node<K, V>[] table) {
        // 1. 获取元素插入位置
        int index = getIndex(key, table.length);
        Node<K, V> node = table[index];
        // 2. 如果该位置为空，直接插入；
        if (node == null) {
            table[index] = new Node<>(key, value);
            size++;
            return;
        }

        // 3. 如果该位置不为空，即发生了冲突，遍历链表。
        while (node != null) {
            boolean same = (hashCode(node.key) == hashCode(key)) && (node.key == key || node.key.equals(key));
            if (same) {
                //4. 如果待插入的元素key和节点相同，用新的value值覆盖旧的；
                node.value = value;
                return;
            }
            node = node.next;
        }

        // 5. 当前key不在链表中，新建节点并插入链表头部
        Node<K, V> newNode = new Node<>(key, value, table[index]);
        table[index] = newNode;
        size++;
    }

    /**
     * 扩容过程：
     * 1. 创建两倍容量的新数组
     * 2. 将当前桶数组的元素重新散列到新的数组
     * 3. 新数组赋值给Map的桶数组
     */
    private void resize() {
        // 1. 创建两倍容量的新数组
        Node<K, V>[] newBuckets =  new Node[2* buckets.length];
        // 2. 将当前桶数组的元素重新散列到新的数组
        rehash(newBuckets);
        // 3. 新数组赋值给Map的桶数组
        this.buckets = newBuckets;
    }

    /**
     * 重新散列当前HashMap中的元素
     * @param newBuckets
     */
    private void rehash(Node<K,V>[] newBuckets) {
        // 重置map大小
        this.size = 0;

        // 将旧的桶数组中的元素全部散列到新的桶数组中
        for (int i = 0; i < this.buckets.length; i++) {
            // 为空，跳过
            if (buckets[i] == null) {
                continue;
            }
            Node<K, V> node = buckets[i];
            // 可能为链表
            while (node != null) {
                putVal(node.key, node.value, newBuckets);
                node  = node.next;
            }
        }
    }

    //------------------get方法-----------------
    /**
     * 获取元素
     * @param key
     * @return
     */
    public V get(K key) {
        // 1. 获取key对应的位置
        int index = getIndex(key, buckets.length);
        Node<K, V> node = buckets[index];
        // 2. 查找链表（不用单独判断是否为链表，这样写都包含了）
        while (node != null) {
            boolean same = (hashCode(node.key) == hashCode(key)) && (node.key == key || node.key.equals(key));
            // 当前node的key和要查找的key相等
            if (same) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    //-------------------返回HashMap的大小----------

    /**
     * 返回HashMap的大小
     * @return
     */
    public int size() {
        return this.size;
    }

}
