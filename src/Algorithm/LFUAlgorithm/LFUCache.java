package Algorithm.LFUAlgorithm;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    // 创建 key 到 value 的映射
    HashMap<Integer, Integer> keyToVal;
    // 创建 key 到 freq 的映射
    HashMap<Integer, Integer> keyToFreq;
    // 创建 freq 到 key 的映射
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    // 记录最小频次
    int minFreq;
    // 记录 LRU 缓存的最大容量
    int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    // 定义 get 方法
    public int get(int key) {
        // 如果 keyToVal 里没有key，返回-1
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        // 否则返回 key 对应的值 val
        increaseFreq(key);  // 自定义的方法
        return keyToVal.get(key);
    }

    // 定义 put 方法，此方法调用时加入对应的 key 和 val 并且使得对应的 freq 设为 1
    public void put(int key, int val) {
        // 如果 cap 小于等于 0，直接结束
        if (cap <= 0) return;
        // ①如果在 keyToVal 里已经含有 key，说明此时只要直接吧值进行覆盖即可，也不需要管要不要淘汰 key 的问题，再将 key 对应的 freq +1
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            increaseFreq(key);
        }

        // ②如果 keyToVal 里不存在这个 key，插入时要考虑要不要淘汰 key 的问题，并将该 key 对应的 freq 设置为 1
        // 如果容量小于 keyToVal 的大小，淘汰 freq 最小的 key
        if (this.cap <= keyToVal.size()) {
            removeMinFreqKey();
        }

        // 如果还有容量，插入 key 和 val，并设置其频率为 1
        // 插入 KV 表
        keyToVal.put(key, val);
        // 插入 KF 表
        keyToFreq.put(key, 1);
        // 插入 FK 表
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        // 此时插入新值的 freq 肯定为 1
        this.minFreq = 1;
    }

    // 定义 removeMinFreqKey 函数
    private void removeMinFreqKey() {
        // freq 最小的 key 列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        // 其中最先插入的 key 就是要被淘汰的 key
        int deleteKey = keyList.iterator().next(); // 一开始迭代器在所有元素的最左边，调用next()方法时，迭代器移动到第一个和第二个元素的之间，并返回迭代器刚经过的元素
        // 更新 FK 表
        keyList.remove(deleteKey); // remove() 方法去除 next() 方法返回的元素
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
            // 因为此方法只在 keyToVal 表容量不够时才会调用，删除 freq 最小的 key，随后就插入了新键值对 key，val，将 minFreq 设置为 1
        }
        // 更新 KV 表
        keyToVal.remove(deleteKey);
        // 更新 KF 表
        keyToFreq.remove(deleteKey);
    }

    // 定义 increaseFreq 函数
    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        // 更新 KF 表
        // 将 key 从 freq 对应的列表中删除
        freqToKeys.get(freq).remove(key);
        // 将 key 加入到 freq + 1 对应的列表中
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>()); // 如果存在重复的 key，那么 putIfAbsent 不会放入值，意思是如果 freq + 1 这个频率不存在则会创建一个列表，否则存在则不创建
        freqToKeys.get(freq + 1).add(key); // 这里在频率对应的列表里加入 key
        // 因为删除了 freq 对应列表里的 key，如果 freq 对应的列表空了的话，移除这个 freq
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            // 如果这个 freq 恰好是 minFreq，先把 freq 和其对应的列表删了(remove() 方法用于删除hashMap 中指定键 key 对应的键值对(key-value))，在更新minFreq
            if (this.minFreq == freq) {
                this.minFreq++;
            }
        }
    }
}
