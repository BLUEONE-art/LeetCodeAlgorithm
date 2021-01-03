package algorithm.binaryTree.lcaFrame;

public class TreeNode {
    public int val;        //节点的值
    public TreeNode node;        //此节点，数据类型为Node
    public TreeNode left;        //此节点的左子节点，数据类型为Node
    public TreeNode right;       //此节点的右子节点，数据类型为Node

    public TreeNode(int value) {
        this.val = value;
        this.left = null;
        this.right = null;
    }
}
