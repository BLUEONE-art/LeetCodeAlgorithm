//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 111 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 核心思想：每次假设当前数字就是“众数”，记为 “+1”
    // 后面若有不同的数字，则记为“-1”
    // 因为众数超过整个数组的一半，所以让最后结果为 “+1” 的数字就是众数
    public int majorityElement(int[] nums) {
        int votes = 0;
        // 假设的众数
        int x = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            // 所以其实等价于
            // votes = votes + ( num == x ? 1 : -1);
            votes += (num == x) ? 1 : -1;
        }
        // 验证 x 是否真的为“众数”
        int count = 0;
        for (int num : nums) {
            if (num == x) count++;
        }
        return count > nums.length / 2 ? x : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
