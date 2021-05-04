//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2318 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 采用单调递减栈
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= height.length - 1; i++) {
            while (!s.isEmpty() && height[i] > height[s.peek()]) {
                // cur:雨水的谷底索引
                int cur = s.peek();
                s.pop();
                if (s.isEmpty()) break;
                // left:左杯壁索引
                int left = s.peek();
                // right:右杯壁索引
                int right = i;
                // 计算当前能盛多少水:体积=宽x高
                int h = Math.min(height[left], height[right]) - height[cur]; // 高度=杯壁的短板 - 谷底
                res += (right - left - 1) * h;
            }
            s.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
