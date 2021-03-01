//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例 1： 
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
//
// 示例 2： 
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 
//
// 限制： 
//
// 
// 最多会对 addNum、findMedian 进行 50000 次调用。 
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-strea
//m/ 
// Related Topics 堆 设计 
// 👍 107 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    // 大顶堆元素：从小到大
    private PriorityQueue<Integer> small;
    // 小顶堆元素：从大到小
    private PriorityQueue<Integer> large;
    /** initialize your data structure here. */
    public MedianFinder() {
        // 正常顺序就是从小打到大的大顶堆
        small = new PriorityQueue<>();
        // 小顶堆要逆序
        large = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
    }

    public void addNum(int num) {
        // 添加元素要维护大顶堆和小顶堆的大小顺序，那个元素少往哪加
        if (small.size() >= large.size()) {
            // 往小顶堆里添加元素
            small.offer(num);
            large.offer(small.poll());
        } else {
            // 往大顶堆加，加之前要维护元素大小顺序，保证加完大顶堆的顶部元素小于小顶堆的顶部元素
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        // 两个堆中的元素一样多，取顶部元素的平均数
        if (small.size() > large.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        return (small.peek() + large.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
