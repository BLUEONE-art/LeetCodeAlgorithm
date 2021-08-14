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
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 
// 👍 310 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 单调递减队列
    public class MonotonicQueue {
        LinkedList<Integer> q;

        /**
         * 初始化
         */
        public MonotonicQueue() {
            q = new LinkedList<>();
        }

        /**
         * 添加元素
         */
        public void push(int val) {
            while (!q.isEmpty() && q.getLast() < val) {
                q.pollLast();
            }
            q.addLast(val);
        }

        /**
         * 获取队列最大值
         * @return
         */
        public int max() {
            return q.getFirst();
        }

        /**
         * 删除元素
         */
        public void pop(int val) {
            if (q.getFirst() == val) {
                q.pollFirst();
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        MonotonicQueue window = new MonotonicQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i + 1 - k]);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
