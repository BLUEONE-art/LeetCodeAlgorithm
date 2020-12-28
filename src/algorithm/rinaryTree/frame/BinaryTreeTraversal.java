package algorithm.rinaryTree.frame;

import java.util.LinkedList;

public class BinaryTreeTraversal {
    /* 二叉树前序遍历 */
    // 代表分隔符的字符
    String SEP = ",";
    // 代表 null 指针的字符
    String NULL = "#";

    /*主函数：将二叉树序列化为字符串 */
    private String freSerialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        freSerialize(root, sb);
        return sb.toString();
    }

    /*辅助函数：将二叉树存入StringBuilder*/
    private void freSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        // 进行前序遍历
        sb.append(root.val).append(SEP);

        freSerialize(root.left, sb);
        freSerialize(root.right, sb);
    }

    /*
    String data = "1, 2, #, 4, #, #, 3, #, #";
    String[] nodes = data.split(",");
    */

    /* 二叉树前序遍历的反序列化 */
    /* 主函数：将字符串反序列化为二叉树结构 */
    private TreeNode deFreSerialize(String data) {
        // 将字符串转换成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s); // 用于将对象链接到List的末尾
        }
        return deFreSerialize(nodes);
    }

    /* 辅助函数：通过 nodes 列表来构造二叉树*/
    private TreeNode deFreSerialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        /* 前序遍历 */
        // nodes列表的最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals(null)) return null;

        // Integer.parseInt(String)的作用就是将String字符类型数据转换为Integer整型数据。
        TreeNode root = new TreeNode(Integer.parseInt(first));
        /* 分隔线 */

        // 其余节点交给递归
        root.left = deFreSerialize(nodes);
        root.right = deFreSerialize(nodes);

        return root;
    }

    /* 二叉树后续遍历 */
    /*主函数：将二叉树序列化为字符串*/
    private String postorderSerialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postorderSerialize(root, sb);
        return sb.toString();
    }

    /* 副函数：将二叉树序列化为字符串 */
    private void postorderSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        // 后序遍历是先递归再进行转化为字符串
        postorderSerialize(root.left, sb);
        postorderSerialize(root.right, sb);

        sb.append(root.val).append(SEP);
    }

    /* 二叉树后序遍历的反序列化 */
    /* 主函数： 将字符串反序列化为二叉树结构 */
    private TreeNode postorderDeserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return postorderDeserialize(nodes);  // 调用副函数
    }

    /* 副函数：通过 nodes 列表构造二叉树 */
    private TreeNode postorderDeserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        /* 反序列化位置 */
        // 从后往前取出元素
        String last = nodes.getLast();
        if (last.equals(null)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));

        // 先构造右子树，后构造左子树
        root.right = postorderDeserialize(nodes);
        root.left = postorderDeserialize(nodes);

        return root;
    }

    /* 二叉树的中序遍历 */
    /* 主函数:将二叉树转换成字符串 */
    private String inorderSerialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        inorderSerialize(root, sb);
        return sb.toString();
    }

    /* 副函数：将二叉树序列化为字符串 */
    private void inorderSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        inorderSerialize(root.left, sb);

        /* 中序遍历的位置 */
        sb.append(root.val).append(SEP);

        inorderSerialize(root.right, sb);
    }
}
