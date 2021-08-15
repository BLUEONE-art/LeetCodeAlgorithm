//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1103 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    int cap;
    // 选用 LinkedHashMap 可以保证快速地添加和删除节点，时间复杂度为 O(1)
    // 并且能够保证快速访问节点，因为 LinkedHashMap 底层是 HashMap + 双向链表
    // HashMap 映射保证可以快速访问节点，双向链表保证了快速增加删除节点
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {

        this.cap = capacity;
    }

    // 快速返回 key 对应的节点
    public int get(int key) {

        if (!cache.containsKey(key)) {
            return -1;
        }

        // 让被 get 的 key 变成最新的
        makeRencently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {

        // ①如果存在 key，直接修改 key 对应的 value 值
        if (cache.containsKey(key)) {
            // 修改值
            cache.put(key, value);
            // 将 key 变成最近使用
            makeRencently(key);
            return;
        }

        // 如果此时 cache 容量已经满了，找到最久未使用的 key 删除
        if (cache.size() >= this.cap) {
            // 链表头部就是最久未使用的 key
            // hash.keySet()是HashMap类中一bai个方法
            // 它的返回类型是一个迭代器Set，也就是说hash.keySet()就有了Set的属性和方法
            int oldestkey = cache.keySet().iterator().next();
            cache.remove(oldestkey); // 删除 key 和对应的 val
        }
        cache.put(key, value);
    }

    private void makeRencently(int key) {
        int val = cache.get(key);
        // 删除 key，重新插入到队尾
        cache.remove(key);
        cache.put(key, val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
