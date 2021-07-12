//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 
// 👍 1919 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return nums[0];
        }
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public int singleNumber(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        if (len <= 1) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (map.get(num) == 1) {
                res = num;
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
