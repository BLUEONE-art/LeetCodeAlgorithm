//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 798 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public class MonotonicQueue {

        // 底层用双向链表实现, 有三个 api
        LinkedList<Integer> q = new LinkedList<>();

        // ①push() 成员方法的实现
        public void push(int n) {

            // 加入元素之前会把 q 中小于该元素的其他元素删除，保持单调递减性
            while (!q.isEmpty() && q.getLast() < n) { // 相等的情况不能删
                q.pollLast();
            }
            // 然后在加入元素 n
            q.addLast(n);
        }

        // ②max() 方法
        public int max() {

            // 因为新加的元素只有当它之前有元素比它大时才会加入
            // 所以链表的头部元素就是最大的
            return q.getFirst();
        }

        // ③pop() 方法
        public void pop(int n) {

            // 因为会出现 q 头部的元素比后来添加的元素小的情况
            // 所以很有可能还没调用 pop() 方法，就被 push() 方法删除了
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        MonotonicQueue window = new MonotonicQueue();
        // 使用数组存放结果方便根据索引查询
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            // 先把窗口的前 k - 1 个元素填满
            if (i < k - 1) {

                window.push(nums[i]);
            } else { // 填充第三个元素的时候要同时计算窗口中的最大值

                // 队尾填充新元素
                window.push(nums[i]);
                // 将窗口中的最大值装入 res
                res.add(window.max());
                // 删除窗口队头的元素，为下一次填充元素求最大值做准备
                window.pop(nums[i - k + 1]);
            }
        }
        // 将 ArrayList res 转换成 int[] 类型返回
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
//        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
