//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈 
// 👍 246 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 寻找下一个更大的元素(循环数组) */
    public int[] nextGreaterElements(int[] nums) {

        // nums 数组的大小
        int size = nums.length;

        // 装结果
        int[] res = new int[size];
        // 装比较的结果，即不断更新的"更大的数"
        Stack<Integer> stack = new Stack<>();

        // 倒着将 nums 数组中的元素放到栈中
        // 利用取模的方法可以使数组在不扩容的情况下实现增倍
        // 假装已经扩容了一倍
        for (int i = 2 * size - 1; i >= 0; i--) {

            // ②通过循环比较元素，更新栈中的“更大的元素”
            while (!stack.isEmpty() && nums[i % size] >= stack.peek()) {

                // 找到了更大的元素，栈中较小的元素就可以舍去
                stack.pop();
            }

            // ③找到了当前元素后第一个比它大的数，更新 res
            res[i % size] = stack.isEmpty() ? -1 : stack.peek();

            // ①放入数组元素
            stack.push(nums[i % size]);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
