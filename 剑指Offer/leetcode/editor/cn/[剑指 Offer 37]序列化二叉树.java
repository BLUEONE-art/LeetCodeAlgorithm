//请实现两个函数，分别用来序列化和反序列化二叉树。 
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
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计 
// 👍 114 👎 0


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
    public String serialize(TreeNode root) {
        // 前序遍历二叉树然后转换成字符串
        StringBuilder sb = new StringBuilder();
        // 方法重载
        serialize(root, sb);
        return sb.toString();
    }
    public void serialize(TreeNode root, StringBuilder sb) {
        // base case
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        // 前序遍历代码位置
        sb.append(root.val).append(SEP);
        // 前序遍历框架位置
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 预处理将字符串的 "," 去掉，并转换成链表
        LinkedList<String> nodes = new LinkedList<>();
        for (String node : data.split(SEP)) {
            nodes.addLast(node);
        }
        return deserialize(nodes);
    }
    public TreeNode deserialize(LinkedList<String> nodes) {
        // base case
        if (nodes.isEmpty()) return null;
        // 序列化后也是按照前序遍历来反序列化结果
        String first = nodes.pollFirst();
        if (first.equals(NULL)) return null;
        // 链表第一个元素就是二叉树的头结点
        TreeNode root = new TreeNode(Integer.parseInt(first));
        // 前序遍历框架位置
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
