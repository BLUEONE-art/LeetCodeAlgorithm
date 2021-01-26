/* 设计一个类，拥有两个 API：*/
class TwoSum {
    // 创建存放 元素 --> 索引 的 HashMap
    HashMap<Integer, Integer> index = new HashMap<>();
    // 向数据结构中添加一个数 number
    public void add(int number) {
        index.put(number, index.getOrDefault(number, 0) + 1);
    }
    // 寻找当前数据结构中是否存在两个数的和为 value
    public boolean find(int value) {
        for (Integer key : index.keySet()) { // 获取 HashMap 中的 key 的集合
            // other = value - key
            int other = value - key;
            // 此时有两个一样的元素组成 value
            if (key == other && index.get(key) > 1) return true;
            // 两个不一样的元素组成
            if (key != other && index.containsKey(other)) return true;
        }
        return false;
    }
}