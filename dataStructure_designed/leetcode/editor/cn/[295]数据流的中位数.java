//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
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
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 堆 设计 
// 👍 332 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {

    /** initialize your data structure here. */
    // 求中位数可以将元素进行排序求中间元素(分奇偶讨论)
    // 可以把排序好的数看成一个大顶堆(倒三角)，从中间一分为二
    // 第一部分：仍是倒三角，即大顶堆
    // 第二部分：成了一个梯形，即小顶堆
    // 大顶堆顶部元素 < 小顶堆顶部元素
    // ①当输入数据为奇数时，中位数就是元素多的那个堆的顶部元素
    // ②当输入数据为偶数时，中位数就是两个堆的顶部元素之和/2
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    public MedianFinder() {
        // 初始化小顶堆
        small = new PriorityQueue<>();
        // 初始化大顶堆
        large = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
    }

    /* 向堆中添加元素 */
    // 核心思想：保持两堆元素个数只差不超过1，并且始终保持大顶堆堆顶元素小于小顶堆堆顶元素
    public void addNum(int num) {

        if (small.size() >= large.size()) {
            // 按道理说此时新加元素要加到大顶堆中
            // 但先把要添加的元素加到小顶堆中进行排序后
            // 将排序好的堆顶元素(大顶堆中的最大元素)加到小顶堆中
            // 保持大顶堆顶部元素 < 小顶堆顶部元素
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    /* 寻找中位数 */
    // 核心思想：使大顶堆和小顶堆元素个数相差不超过 1
    public double findMedian() {

        // 如果两个堆元素不相同，则元素多的堆的顶部元素必是中位数
        if (small.size() > large.size()) {
            return small.peek();
        } else if (large.size() > small.size()){
            return large.peek();
        }

        // 两个堆元素相等
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
