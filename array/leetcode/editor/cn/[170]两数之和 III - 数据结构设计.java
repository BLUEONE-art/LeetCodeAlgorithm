/* 设计一个类，拥有两个 API：哈希表实现*/
class TwoSum {
    // 创建存放 元素 --> 出现频次 的 HashMap
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

/* 设计一个类，拥有两个 API：哈希集合实现*/
class TwoSum {
    // 创建存放所有元素全部组合的 sum
    Set<Integer> sum = new HashSet<>();
    // 创建存放 number 的数组
    ArrayList<Integer> nums = new ArrayList<>();
    // 向数据结构中添加一个数 number
    public void add(int number) {
        for (Integer num : nums) {
            sum.add(num + number);
        }
        nums.add(number);
    }
    // 寻找当前数据结构中是否存在两个数的和为 value
    public boolean find(int value) {
        return sum.containsKey(value);
    }
}