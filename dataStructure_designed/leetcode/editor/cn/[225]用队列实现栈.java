//使用队列实现栈的下列操作： 
//
// 
// push(x) -- 元素 x 入栈 
// pop() -- 移除栈顶元素 
// top() -- 获取栈顶元素 
// empty() -- 返回栈是否为空 
// 
//
// 注意: 
//
// 
// 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合
//法的。 
// 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。 
// 
// Related Topics 栈 设计 
// 👍 263 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {

    Queue<Integer> q;
    int top_elem;
    /** Initialize your data structure here. */
    public MyStack() {

        q = new LinkedList<>();
        this.top_elem = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {

        // 因为底层是队列，先进先出(尾部加入，头部取出)
        // 用于实现栈，则新加入队列的元素(队列尾部)为栈顶元素
        q.offer(x);
        top_elem = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

        // 获取栈顶(队列尾部)元素好获取，因为在每次 push() 的时候可以用一个变量记录
        // 但是 remove 的时候，队列仅提供队列头部元素的 remove 方法
        // 将队头的元素取出来重新添加到队尾，这样队尾的元素就被提到队头了
        int size = q.size();
        // 暂时保存队尾的两个元素
        while (size > 2) {

            // 循环将队列头部的元素加到队尾
            q.offer(q.poll());
            size--;
        }

        // 此时原队列尾部的两个元素被移到头部了
        // 更新 top_elem：即为即将要放到队尾的元素
        top_elem = q.peek();
        // 再把这个元素移到队尾
        q.offer(q.poll());
        // 此时原来在队尾的元素被真正移到队头了，返回即可
        return q.poll();
    }

    /** Get the top element. */
    public int top() {

        // 返回栈顶元素，即 push() 后的元素 top_elem
        return top_elem;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
