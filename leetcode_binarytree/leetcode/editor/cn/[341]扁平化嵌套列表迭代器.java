//给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。 
//
// 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。 
//
// 
//
// 示例 1: 
//
// 输入: [[1,1],2,[1,1]]
//输出: [1,1,2,1,1]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 
//
// 示例 2: 
//
// 输入: [1,[4,[6]]]
//输出: [1,4,6]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
// 
// Related Topics 栈 设计 
// 👍 185 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

//    N 叉树解法
//    private Iterator<Integer> it;
//    // List<NestedInteger> 是一个包含 NestedInteger 整数和 NestedInteger 类型列表的一个无线嵌套的结果
//    // [1, 2, [1, 2], [1, [1, 2]], 3, [1, [12, 2, [1, 3, 4]]]]
//    public NestedIterator(List<NestedInteger> nestedList) {
//        // 创建一个 result 列表存放将 List<NestedInteger> ”打平“之后的结果
//        List<Integer> result = new LinkedList<>();
//        for (NestedInteger node : nestedList) {
//
//            // 以每个节点为根节点进行遍历，遍历函数：traverse()
//            traverse(node, result);
//        }
//        // 得到 result 列表的迭代器
//        this.it = result.iterator();
//    }
//
//    @Override
//    // 迭代器不是静止不动的，它是随着 next()方法而移动的
//    // 一开始迭代器在所有元素的左边，调用next()之后，迭代器移到第一个和第二个元素之间，next()方法返回迭代器刚刚经过的元素。
//    // hasNext()若返回True，则表明接下来还有元素，迭代器不在尾部。
//    // remove()方法必须和next方法一起使用，功能是去除刚刚next方法返回的元素。
//    public Integer next() {
//
//        return it.next();
//    }
//
//    @Override
//    public boolean hasNext() {
//
//        return it.hasNext();
//    }
//
//    public void traverse(NestedInteger root, List<Integer> result) {
//
//        // base case：如果 root.isInteger() 返回 true, 说明此时的 root 是叶子节点
//        if (root.isInteger()) {
//
//            result.add(root.getInteger());
//            return;
//        }
//
//        // 如果不是叶子节点，root.getList() 返回 List<NestedInteger> 列表
//        // 再对这个列表里的 child 节点进行遍历判断：
//        // 如果 child.getInteger() 为 true，就把这个节点装入 result
//        // 否则继续遍历，以此输出所有的叶子节点的值装入 result 列表
//        // N 叉树递归遍历过程
//        for (NestedInteger child : root.getList()) {
//
//            traverse(child, result);
//        }
//    }

    // 循环求拆解 NestedInteger 列表解法
    private LinkedList<NestedInteger> list;
    // List<NestedInteger> 是一个包含 NestedInteger 整数和 NestedInteger 类型列表的一个无线嵌套的结果
    // [1, 2, [1, 2], [1, [1, 2]], 3, [1, [12, 2, [1, 3, 4]]]]
    public NestedIterator(List<NestedInteger> nestedList) {

        // 不直接用 nestedList 的引用，是因为不能确定它的底层实现
        // 必须保证是 LinkedList，否则下面的 addFirst 会很低效
        list = new LinkedList<>(nestedList);
    }

    @Override
    // 迭代器不是静止不动的，它是随着 next()方法而移动的
    // 一开始迭代器在所有元素的左边，调用next()之后，迭代器移到第一个和第二个元素之间，next()方法返回迭代器刚刚经过的元素。
    // hasNext()若返回True，则表明接下来还有元素，迭代器不在尾部。
    // remove()方法必须和next方法一起使用，功能是去除刚刚next方法返回的元素。
    // 因为 hasNext() 方法保证了将 NestedInteger 列表的第一个元素为“打平”之后的整数
    public Integer next() {

        // 返回列表中的整数
        return list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {

        // 当 list 列表中第一个元素是一个被嵌套的列表时，将其展开
        while (!list.isEmpty() && !list.get(0).isInteger()) {

            // 取出 list 列表中的第一个元素并删除,这样下一个列表中的元素才能到第一个位置
            List<NestedInteger> first = list.remove(0).getList();

            // 将 first 列表中的元素“打平”
            // 即使 first 列表中还有 NestedInteger 类型的列表嵌套，只要 list 的第一个元素不是整数，一直在 while 循环
            for (int i = first.size() - 1; i >= 0; i--) {

                list.addFirst(first.get(i));
            }
        }

        return !list.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)
