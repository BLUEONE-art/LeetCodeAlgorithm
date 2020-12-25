package Algorithm.BinaryTree;

import sun.reflect.generics.tree.Tree;

public class NodesOfBinaryTree {
    // ①输入普通二叉树的情况
    public int countNormalBinaryTree(TreeNode root) {
        // 如果根节点为null，返回0
        if (null == root) return 0;
        // 剩下的交给递归完成
        return 1 + countNormalBinaryTree(root.left) + countNormalBinaryTree(root.right);
    }

    // ②如果是一颗满二叉树，节点的总数就和树的高度呈指数关系
    public int countPerfectTree(TreeNode root) {
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

    // ③如果是完全二叉树，它比普通二叉树特殊，但没有满二叉树那么特殊，所以计算它的节点是普通二叉树和完全二叉树的结合版
    public int countCompleteTree(TreeNode root) {
        TreeNode l = root, r = root;
        // 记录左、右子树的高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hl++;
        }
        if (hl == hr) {
            return (int)Math.pow(2, hl) - 1;
        }
        return 1 + countCompleteTree(l.left) + countCompleteTree(l.right);
    }
}
