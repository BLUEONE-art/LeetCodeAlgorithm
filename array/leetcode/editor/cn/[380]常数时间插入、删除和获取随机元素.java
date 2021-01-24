//设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。 
//
// 
// insert(val)：当元素 val 不存在时，向集合中插入该项。 
// remove(val)：元素 val 存在时，从集合中移除该项。 
// getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。 
// 
//
// 示例 : 
//
// 
//// 初始化一个空的集合。
//RandomizedSet randomSet = new RandomizedSet();
//
//// 向集合中插入 1 。返回 true 表示 1 被成功地插入。
//randomSet.insert(1);
//
//// 返回 false ，表示集合中不存在 2 。
//randomSet.remove(2);
//
//// 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
//randomSet.insert(2);
//
//// getRandom 应随机返回 1 或 2 。
//randomSet.getRandom();
//
//// 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
//randomSet.remove(1);
//
//// 2 已在集合中，所以返回 false 。
//randomSet.insert(2);
//
//// 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
//randomSet.getRandom();
// 
// Related Topics 设计 数组 哈希表 
// 👍 259 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/* 以 O(1) 时间复杂度完成插入、删除、随机获取元素的操作*/
class RandomizedSet {
    // 想要以 O(1) 随机访问元素，必选数组实现
    ArrayList<Integer> nums;
    // 创建 HashMap 记录数组元素对应的索引值
    HashMap<Integer, Integer> valToIndex;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.nums = new ArrayList<>();
        this.valToIndex = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        // 如果数组中存在 val，则返回false
        if (valToIndex.containsKey(val)) return false;
        // 想要以 O(1) 复杂度插入元素，为了避免移动元素，必须将元素插入至数组末尾
        // 没加任何数之前，nums.size() == 0
        valToIndex.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        // 如果元素不存在 val，返回false
        if (!valToIndex.containsKey(val)) return false;
        // 想要以 O(1) 复杂度移除元素，先将要删除元素移动至数组末尾，再删除
        int index = valToIndex.get(val); // 获取 val 的索引 index
        // 将 valToIndex 中最后元素(即 nums 里最后的元素)索引换成 index
        valToIndex.put(nums.get(nums.size() - 1), index);
        // 将数组中 val 和 最后的元素互换位置, 此时 val 就是最后的元素
        Collections.swap(nums, index, nums.size() - 1);
        // 删除数组最后一个元素，即为 val
        nums.remove(nums.size() - 1);
        // 删除 valToIndex 中 val 对应的索引
        valToIndex.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get((int)(Math.random() * nums.size()));
    }

//    private Integer[] table = null;
//    private int size = 0;
//
//    /** Initialize your data structure here. */
//    public RandomizedSet() {
//        table = new Integer[2];
//    }
//
//    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
//    public boolean insert(int val) {
//        Integer v = new Integer(val);
//        int index;
//        if (table[index = (v.hashCode()& (table.length-1))] == null) {
//            table[index] = v;
//            size++;
//            return true;
//        } else if (table[index] != val){
//            //扩容然后再插
//            reSize();
//            return insert(val);
//        }
//        return false;
//    }
//
//    private boolean reSize() {
//        Integer[] oldTable, newTable;
//        if ((oldTable = table) != null) {
//            newTable = new Integer[oldTable.length << 1];
//            for (int i = 0; i < oldTable.length; i++) {
//                if (oldTable[i] != null)
//                    newTable[oldTable[i].hashCode()&(newTable.length-1)] = oldTable[i];
//            }
//            this.table = newTable;
//            return true;
//        }
//        return false;
//    }
//
//    /** Removes a value from the set. Returns true if the set contained the specified element. */
//    public boolean remove(int val) {
//        int index;
//        if (table[index = (Integer.hashCode(val)&(table.length-1))] != null && table[index] == val) {
//            table[index] = null;
//            size--;
//            return true;
//        }
//        return false;
//    }
//
//    /** Get a random element from the set. */
//    public int getRandom() {
//        int index = (int)(Math.random()*(table.length));
//        while(table[index] == null && size > 0){
//            index = (int)(Math.random()*(table.length));
//        }
////        return table[index];
//        return index;
//    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
