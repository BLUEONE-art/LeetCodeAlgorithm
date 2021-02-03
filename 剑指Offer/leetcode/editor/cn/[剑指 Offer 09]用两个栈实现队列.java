//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计 
// 👍 171 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class CQueue {
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    public CQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }
    // 队列尾部插入元素
    public void appendTail(int value) {
        stk1.push(value);
    }
    // 队列头部删除元素
    public int deleteHead() {
        // 容量为 0 时，返回 -1
        if (stk1.isEmpty() && stk2.isEmpty()) return -1;
        // 只要把栈 stk1 中的元素拿出来放到 stk2 中，在 pop 即可
        if (stk2.isEmpty()) {
            while (!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
        }
        return stk2.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)
