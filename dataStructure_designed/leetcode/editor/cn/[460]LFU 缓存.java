//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。 
//
// 实现 LFUCache 类： 
//
// 
// LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象 
// int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。 
// void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之
//前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。 
// 
//
// 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。 
//
// 
//
// 进阶： 
//
// 
// 你是否可以在 O(1) 时间复杂度内执行两项操作？ 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "g
//et"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//输出：
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//解释：
//LFUCache lFUCache = new LFUCache(2);
//lFUCache.put(1, 1);
//lFUCache.put(2, 2);
//lFUCache.get(1);      // 返回 1
//lFUCache.put(3, 3);   // 去除键 2
//lFUCache.get(2);      // 返回 -1（未找到）
//lFUCache.get(3);      // 返回 3
//lFUCache.put(4, 4);   // 去除键 1
//lFUCache.get(1);      // 返回 -1（未找到）
//lFUCache.get(3);      // 返回 3
//lFUCache.get(4);      // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 0 <= capacity, key, value <= 104 
// 最多调用 105 次 get 和 put 方法 
// 
// Related Topics 设计 
// 👍 319 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class LFUCache {

    // 缓存容量
    int cap;
    // 创建 minFreq
    int minFreq;
    // 创建 key-val 表，能够快速根据 key 查询到对应的 val 值
    HashMap<Integer, Integer> keyToVal;
    // 创建 key-freq 表，能够快速查询 key 对应的 freq
    HashMap<Integer, Integer> keyToFreq;
    // 创建 freq-keys 表，能够快速根据 freq 查询到对应的 keys 列表
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        // 初始化各种表和初始值
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    /* get()：查询缓存中的键 key */
    // ①如果不存在 key，返回 -1；
    // ②如果存在 key，返回对应的 val，并且使 key 对应的 freq + 1
    public int get(int key) {

        if (!keyToVal.containsKey(key)) return -1;

        // 否则存在 key，调用它时会将 key 对应的 freq + 1
        increaseFreq(key);
        return keyToVal.get(key);
    }

    /* put()：插入或修改缓存 */
    // ①如果存在 key：将原始的 key 对应的 val 修改为新值，并将 key 的 freq + 1

    // ②如果不存在 key：
    // i)缓存容量未满,不存在键 key：插入键值对(key, val)，并将 key 的 freq 设置为 1

    // ii)缓存容量已满不存在键 key：此时容量已满，想加入新的 key 必须删除旧的 key
    // 要找到 minFreq 对应的 key 列表，如果 minFreq 对应多个 key，找到列表中最靠前的 key 删除
    public void put(int key, int value) {
        if (this.cap <= 0) return;

        if (keyToVal.containsKey(key)) {

            keyToVal.put(key, value);
            increaseFreq(key);
            return; // 如果包含，执行到此即结束，剩下的就是不包括 key 的情况
        }

        // 不存在 key && 容量已满
        if (keyToVal.size() >= this.cap) {
            removeMinFreqKey();
        }

        // 此时包括两种情况：
        // ①容量已满并且删除了 minFreq 对应的 key 之后要 put(key, value)
        // ②容量没满自然要 put(key, value)
        keyToVal.put(key, value);

        // 更新另外两张表，因为这个 key 时新增的
        keyToFreq.put(key, 1);
        // putIfAbsent()：如果 1 频次没有对应的 LinkedHashSet，则 new 一个
        // 否则就使用旧的，不 new
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);

        // 此时是新增 key，其对应的频次即为最小频次
        this.minFreq = 1;
    }

    // 写 util 函数 removeMinFreqKey()
    private void removeMinFreqKey() {

        // 先要找到 freqToKeys 表中最小频次对应的 keys 列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        // keyList 中可能存在很多个 key，要找到最旧的那个 key 删除
        int oldestKey = keyList.iterator().next();
        // 更新 freqToKeys 表
        keyList.remove(oldestKey);
        // 如果 minFreq 对应的 keys 列表都空了，就需要删除
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }
        // 更新 keyToVal 表
        keyToVal.remove(oldestKey);
        // 更新 keyToFreq 表
        keyToFreq.remove(oldestKey);
    }

    // 写 util 函数 increaseFreq()
    // 这里肯定在 keyToVal.put() 之后，只需要更新另外两个表
    private void increaseFreq(int key) {

        // 更新 keyToFreq 表
        // 获取 key 的原始频次
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        // 更新 freqToKeys 表
        // 此时 key 的 freq 变了，所以需要把它从原来频次对应的 keys 表中删除
        freqToKeys.get(freq).remove(key);
        // 新建一个 freq + 1 的 keys 表，如果有就不需要建，并把 key 放入
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        // 考虑 freq 频次对应的 keys 表中元素被全部取出的情况
        if (freqToKeys.get(freq).isEmpty()) {

            // 删除这个频次
            freqToKeys.remove(freq);
            // 如果 freq 为 minFreq, 表示 minFreq 对应的 keys 表元素被全部取出啦
            // 需要让 minFreq++ 作为新的 minFreq
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
