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
// 👍 2335 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= height.length - 1; i++) {
            while (!s.isEmpty() && height[i] > height[s.peek()]) { // 后面比前面大
                int bottom = s.peek();
                s.pop(); // 谷底拿到了就可以被弹出
                if (s.isEmpty()) break;
                int left = s.peek(); // 弹走一个谷底，左杯壁就是栈顶数据
                int h = Math.min(height[left], height[i]) - height[bottom]; // i就是右杯壁索引
                res += (i - left - 1) * h;
            }
            s.push(i); // 放索引
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
