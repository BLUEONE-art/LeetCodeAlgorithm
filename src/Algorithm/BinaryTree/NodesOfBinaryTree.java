package Algorithm.BinaryTree;

public class NodesOfBinaryTree {
    // ①输入普通二叉树的情况
    public int countNormalBinaryTree(TreeNode root) {
        // 如果根节点为null，返回0
        if (null == root) return 0;
        // 剩下的交给递归完成
        return 1 + countNormalBinaryTree(root.left) + countNormalBinaryTree(root.right);
    }

    // ②如果是一颗满二叉树，节点的总数就和树的高度呈指数关系
    public int countCompleteTree(TreeNode root) {
        // 初始化高度为 0
        int h = 0;
        // 计算树的高度
        while(root != null) {
            root = root.left;
            h++;
        }
        // 满二叉树的总的节点数就是 2^h -1
        return (int)Math.pow(2, h) - 1; // 求2的h次方，然后强制转换成int类型 - 1
    }
}
