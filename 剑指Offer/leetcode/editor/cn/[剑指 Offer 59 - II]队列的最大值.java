//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都
//是O(1)。 
//
// 若队列为空，pop_front 和 max_value 需要返回 -1 
//
// 示例 1： 
//
// 输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
// 
//
// 示例 2： 
//
// 输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
// Related Topics 栈 Sliding Window 
// 👍 197 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
// 维护两个队列，一个是正常的，一个是单调递减的队列
class MaxQueue {
    Queue<Integer> queue;
    // 双向队列：介意在对头和队尾加入元素
    Deque<Integer> deque;
    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        // deque 第一位放着最大值，不出队，只获取元素即可
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    // 入队操作
    public void push_back(int value) {
        // 对于队列而言直接加入即可
        queue.offer(value);
        // 对于双向队列而言，需要维护其单调 递减 特性
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        // 双向队列中加入元素
        deque.offerLast(value);
    }

    // 出队操作
    public int pop_front() {
        // 对于队列来说，如果为 0，返回 -1，如果不为 0，返回对头元素
        if (queue.isEmpty()) return -1;
        // 对于双向队列而言，只有当队列 pop 的元素与对头元素相同时才出队
        if (queue.peek().equals(deque.peekFirst())) {
            deque.pollFirst();
        }
        return queue.poll();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)
