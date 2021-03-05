//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 825 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> supportStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        supportStack = new Stack<>();
    }
    // 维护一个从栈顶到栈底单调递增的辅助栈
    public void push(int x) {
        stack.push(x);
        if (supportStack.empty() || x <= supportStack.peek()) {
            supportStack.push(x);
        }
        // 否则当单调栈不为空或者 x > 栈顶元素，直接不添加
    }

    public void pop() {
        // 看看是不是弹出了最小值，即单调栈的栈顶元素
        if (stack.pop().equals(supportStack.peek())) {
            supportStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return supportStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
