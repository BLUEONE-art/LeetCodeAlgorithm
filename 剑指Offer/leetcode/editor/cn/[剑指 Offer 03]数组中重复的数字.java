//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 
// 👍 261 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 找到数组中重复的数组并输出 */
    public int findRepeatNumber(int[] nums) {
        // 思路：把数组中的元素和他对应的出现次数放入哈希表，次数大于 1 的元素输出
        int res = 0;
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        for (int num : nums) {
            valToFreq.put(num, valToFreq.getOrDefault(num, 0) + 1);
            if (valToFreq.get(num) > 1) {
                res = num;
                break;
            }
        }
        return res;
    }

    /* 找到数组中重复的数组并输出 */
    public int findRepeatNumber(int[] nums) {
        // 思路：把数组中的元素和他对应的出现次数放入 HashSet，如果放入成功，不重复，放入失败，重复，返回即可
        HashSet<Integer> set = new HashSet<>();
        int repeat = 0;
        for (int num : nums) {
            // 没添加成功
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
