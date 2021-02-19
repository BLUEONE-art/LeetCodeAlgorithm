//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 187 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public class MonotonicQueue {
        // 双向链表实现单调队列，有入队、出队、求最大值三种 API
        LinkedList<Integer> q = new LinkedList<>();
        // 入队时保证队列单调递减的特性
        public void push(int n) {
            // 进来先判断：只有队列的末尾元素比要添加元素大或等于，才能添加入队
            while (!q.isEmpty() && q.getLast() < n) {
                q.pollLast();
            }
            q.addLast(n);
        }
        // 求队列中的最大值，即为队头元素
        public int max() {
            // 不用 pollFirst()：因为删除队列元素由 pop 完成
            return q.getFirst();
        }
        // 出队
        public void pop(int n) {
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 定义窗口
        MonotonicQueue window = new MonotonicQueue();
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 先装 k - 1 个
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                // 开始添加第 k 个元素
                window.push(nums[i]);
                tmp.add(window.max());
                // 去除第一个元素，为下一次滑动窗口做准备
                window.pop(nums[i - k + 1]);
            }
        }
        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
