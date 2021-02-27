//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// 👍 129 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        // 定义数组存放 nums 数组中每一位上 “1” 的个数和
        int[] count_1 = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                // 对于每一个数字 num 每一遍都求一次 "&1" 的结果，使用 "+=" 来累加所有 num 中每一位对应的 1 的个数
                count_1[i] = count_1[i] + (num & 1);
                // num 无符号右移一位
                num >>>= 1;
            }
        }
        // 因为数组中重复数字出现 3 次，所以其位数和 % 3 == 0
        // 位数和 % 3 != 0 的位数用 2^j 求和起来就是出现一次的数
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (count_1[i] % 3 != 0) {
                res += Math.pow(2, i);
            }
        }
        return res;

        // 直接思路的解法
        HashMap<Integer, Integer> numToFreq = new HashMap<>();
        int left = 0;
        while (left <= nums.length - 1) {
            numToFreq.put(nums[left], numToFreq.get(nums[left]) == null ? 1 : -1);
            left++;
        }
        for (Integer key : numToFreq.keySet()) {
            if (numToFreq.get(key) == 1) return key;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
