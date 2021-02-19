//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 95 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 充分条件：在不考虑大小王的情况下，当数组中最大元素和最小元素之差小于 5 时，即可组成顺子
    public boolean isStraight(int[] nums) {
        // 如有重复的牌，直接返回 false
        HashSet<Integer> set = new HashSet<>();
        int min = 14, max = 0;
        for (int num : nums) {
            // 碰到 0，直接跳过
            if (num == 0) continue;
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (set.contains(num)) return false;
            set.add(num);
        }
        return max - min < 5;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
