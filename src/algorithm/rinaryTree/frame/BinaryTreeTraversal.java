package algorithm.rinaryTree.frame;

import java.util.LinkedList;

public class BinaryTreeTraversal {
    // 二叉树前序遍历
    // 代表分隔符的字符
    String SEP = ",";
    // 代表 null 指针的字符
    String NULL = "#";

    /*主函数：将二叉树序列化为字符串*/
    private String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    /*辅助函数：将二叉树存入StringBuilder*/
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        // 进行前序遍历
        sb.append(root.val).append(SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    /*
    String data = "1, 2, #, 4, #, #, 3, #, #";
    String[] nodes = data.split(",");
    */

    /* 主函数：将字符串反序列化为二叉树结构 */
    private TreeNode deserialize(String data) {
        // 将字符串转换成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s); // 用于将对象链接到List的末尾
        }
        return deserialize(nodes);
    }

    /* 辅助函数：通过 nodes 列表来构造二叉树*/
    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        /* 前序遍历 */
        // nodes列表的最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals(null)) return null;

        // Integer.parseInt(String)的作用就是将String字符类型数据转换为Integer整型数据。
        TreeNode root = new TreeNode(Integer.parseInt(first));
        /* 分隔线 */

        // 其余节点交给递归
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }

}
