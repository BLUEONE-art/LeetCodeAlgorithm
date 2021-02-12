//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 
// 👍 88 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    Stack<Integer> minStack;
    // 辅助单调栈：单调递减
    Stack<Integer> monotonousStack;
    /** initialize your data structure here. */
    public MinStack() {
        this.minStack = new Stack<>();
        this.monotonousStack = new Stack<>();
    }
    // 往栈中加入元素
    public void push(int x) {
        minStack.add(x);
        // 保证单调栈单调递减
        if (monotonousStack.empty() || x <= monotonousStack.peek()) {
            monotonousStack.add(x);
        }
    }
    // 弹出栈顶元素
    public void pop() {
        if (minStack.pop().equals(monotonousStack.peek())) {
            monotonousStack.pop();
        }
    }
    // 返回栈顶元素
    public int top() {
        return minStack.peek();
    }
    // 求出栈中最小的元素
    public int min() {
        return monotonousStack.peek();
    }

//    int minValue;
//    int secondMinValue;
//    // 记录最小值出现的次数
//    HashMap<Integer, Integer> valToFreq;
//    /** initialize your data structure here. */
//    public MinStack() {
//        this.minStack = new Stack<>();
//        this.minValue = Integer.MAX_VALUE;
//        this.secondMinValue = Integer.MAX_VALUE;
//        this.valToFreq = new HashMap<>();
//    }
//    // 往栈中加入元素
//    public void push(int x) {
//        // 记录每个元素出现的频次
//        valToFreq.put(x, valToFreq.getOrDefault(x, 0) + 1);
//        // 如果此时加入的 x 比 minValue 小，记录第二小的值
//        if (x < minValue) {
//            secondMinValue = minValue;
//        }
//        // 每次加入元素都会跟栈顶元素进行比较，取较小值
//        minValue = Math.min(x, minValue);
//        minStack.push(x);
//    }
//    // 弹出栈顶元素
//    public void pop() {
//        if (minStack.peek() != minValue) {
//            valToFreq.put(minStack.peek(), valToFreq.getOrDefault(minStack.peek(), 0) - 1);
//            minStack.pop();
//        } else if (minStack.peek() == minValue) {
//            valToFreq.put(minStack.peek(), valToFreq.getOrDefault(minStack.peek(), 0) - 1);
//            if (valToFreq.get(minStack.peek()) == 0) {
//                minValue = secondMinValue;
//            }
//            minStack.pop();
//        }
//    }
//    // 返回栈顶元素
//    public int top() {
//        return minStack.peek();
//    }
//    // 求出栈中最小的元素
//    public int min() {
//        return minValue;
//    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)
