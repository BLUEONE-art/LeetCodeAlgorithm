//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表 
// 👍 617 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 寻找下一个更大的温度 */
    public int[] dailyTemperatures(int[] T) {

        // 装结果
        int[] res = new int[T.length];
        // 装索引
        Stack<Integer> stack = new Stack<>();

        // 将数组 T 中元素索引倒着入栈
        for (int i = T.length - 1; i >= 0; i--) {

            // ②循环进行元素大小比较
            // 如果栈中元素不为空，说明此时有比当前元素大的值
            // 如果战争没有元素，说明该元素后面没有比他大的
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {

                // 如果栈中索引对应的值没有当前 T 数组中的元素大，那栈中索引对应的值可以“走了”
                stack.pop();
            }

            // ③将比较结果放入 res
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;

            // ①元素索引入栈
            stack.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
