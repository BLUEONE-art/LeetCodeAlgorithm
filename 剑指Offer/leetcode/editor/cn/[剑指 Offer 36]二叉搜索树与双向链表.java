//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。 
//
// 
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例： 
//
// 
//
// 
//
// 
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。 
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。 
//
// 
//
// 
//
// 
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。 
//
// 
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
//to-sorted-doubly-linked-list/ 
//
// 注意：此题对比原题有改动。 
// Related Topics 分治算法 
// 👍 184 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        // 中序遍历函数
        inorder(root);
        // 对遍历的结果头尾相接形成循环链表
        pre.right = head;
        head.left = pre;
        return head;
    }
    public void inorder(Node cur) {
        // base case
        if (cur == null) return;
        // 中序遍历的位置
        inorder(cur.left);
        /* 中序遍历代码位置 */
        // 第一次递归的时候拿到的是头结点，其左侧没有节点，即 cur 节点左侧没有 pre 节点
        if (pre != null) {
            cur.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        // 记录当前的 cur，因为下次递归 cur 就会递增成下一个节点
        pre = cur;
        /* 中序遍历代码位置 */
        inorder(cur.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
