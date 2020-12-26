package algorithm.rinaryTree.frame;

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


}
