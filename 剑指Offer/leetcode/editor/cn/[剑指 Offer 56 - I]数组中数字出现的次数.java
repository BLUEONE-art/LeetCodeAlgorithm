//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 310 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        // 让 nums 中所有的数都进行异或操作，因为只有两个不同的数出现了一次，所以异或结果就是那两个只出现一次的数的异或结果
        int k = 0;
        for (int num : nums) {
            // 两个不同的数的异或结果
            k ^= num;
        }
        // 找到异或结果中第一位不为 0 的位
        int mask = 1;
        while ((k & mask) == 0) {
            mask <<= 1;
        }
        // 根据这一位来对 nums 数组中的数进行分组
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
