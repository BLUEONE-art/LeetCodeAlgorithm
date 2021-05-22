package algorithm.ip_93;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        System.out.println(treeToDoublyList(root));
    }

    static class Node {
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

    static Node pre, head;
    public static Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root); // 中序遍历完成了除头尾相连的其他工作
        pre.right = head; // pre是尾部
        head.left = pre; // head头部
        return head;
    }

    public static void dfs(Node root) {
        if (root == null) return;
        dfs(root.left);
        // 中序遍历代码位置
        if (pre == null) {
            head = root;
        }
        else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        // 中序遍历代码位置
        dfs(root.right);
    }
}

//     static List<String> res = new ArrayList<>();
//    static int[] path = new int[4];
//    public static List<String> restoreIpAddresses(String s) {
//        helper(s.toCharArray(),0, 0);
//        return res;
//    }
//
//    public static void helper(char[] str, int idx, int resIdx) {
//        // 终止条件
//        if (resIdx == 4) {
//            if (idx == str.length) {
//                StringBuilder sb = new StringBuilder();
//                for (int i = 0; i < 3; i++) {
//                    sb.append(path[i]);
//                    sb.append('.');
//                }
//                sb.append(path[3]);
//                res.add(sb.toString());
//            }
//            return;
//        }
//        if (idx == str.length) return; // resIdx == 4 && idx == str,length
//        // 回溯
//        if (str[idx] == '0') { // 只需回溯一次
//            path[resIdx] = 0;
//            helper(str, idx + 1, resIdx + 1);
//        }
//        int tmp = 0;
//        for (int i = idx; i < str.length; i++) {
//            tmp = tmp * 10 + (str[i] - '0');
//            if (tmp > 0 && tmp < 256) {
//                path[resIdx] = tmp;
//                helper(str, i + 1, resIdx + 1);
//            } else break;
//        }
//    }




