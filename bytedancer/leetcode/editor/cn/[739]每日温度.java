//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表 
// 👍 758 👎 0

//     public int[] dailyTemperatures(int[] temperatures) {
//        int[] res = new int[temperatures.length];
//        int count = 0;
//        for (int i = 0; i < temperatures.length; i++) {
//            for (int j = i; j < temperatures.length; j++) {
//                if (temperatures[i] >= temperatures[j]) { // 没有更大的数
//                    count++;
//                }
//                else { // 有更大的数
//                    res[i] = count;
//                    break;
//                }
//            }
//            count = 0;
//        }
//        return res;
//    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[i] >= temperatures[s.peek()]) { // ②
                s.pop();
            }
            res[i] = s.isEmpty() ? 0 : s.peek() - i; // ③

            s.push(i); // ①
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
