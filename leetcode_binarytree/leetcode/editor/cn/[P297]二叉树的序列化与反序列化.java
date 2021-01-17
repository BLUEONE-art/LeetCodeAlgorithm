//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。 
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计 
// 👍 447 👎 0

package com.yourname.leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2021-01-17 10:05:42
 */
public class SerializeAndDeserializeBinaryTree{
    public static void main(String[] args) {
        Solution solution = new SerializeAndDeserializeBinaryTree().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    String SEP = ",";
    String NULL = "#";
    // Encodes a tree to a single string.
    // 前序遍历的解法
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder<>();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {

        // base case
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        // 前序遍历代码的位置
        sb.append(root.val).append(SEP);

        // 前序遍历框架位置
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        // 预处理：将字符串中 “,” 去掉并放到链表中
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    public TreeNode deserialize(LinkedList<String> nodes) {

        // base case
        if (nodes.isEmpty()) return null;

        // 前序遍历代码位置
        // 明确两件事情
        // ①在前序遍历序列化的结果中找到根节点，很明显是列表的第一个
        // ②拿到根节点，要做什么？然后剩下的交给递归
        String first = nodes.removeFirst();
        // 虽然 nodes 此时不为空，但需要有一个结束的条件
        if (first == null) return null;

        // 构建 root 根节点
        TreeNode root = new TreeNode(first);

        // 前序遍历框架位置
        root.left = deserialize(nodes);
        root.right = deserialize(nodes); // 此时的 nodes 已经是取完第一个元素之后剩下的了

        // 返回 root
        return root;
    }
    String name = "Dh";
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}