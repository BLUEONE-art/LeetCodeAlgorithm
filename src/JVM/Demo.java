package JVM;


import org.junit.Test;

import java.util.*;

public class Demo {
//    public static void main(String[] args) {
//        // 返回虚拟机试图使用的最大内存(字节)
//        long max = Runtime.getRuntime().maxMemory(); // byte --> 除以 1024 得KB --> 除以 1024 得 MB
//        // 返回 JVM 初始化的总内存(字节)
//        long total = Runtime.getRuntime().totalMemory();
//
//        System.out.println("max虚拟机试图使用的最大内存=" + max + "字节\t" +
//                "转换为MB=" + (max/(double)1024/1024) + "MB");
//
//        System.out.println("total虚拟机初始化的总内存=" + total + "字节\t" +
//                "转换为MB=" + (total/(double)1024/1024) + "MB");
//    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @Test
    public static void main(String[] args) {
//        int operationLen = 8;
//        char[] operations = new char[]{'-', '+', '-', '-', '+', '-', '-', '+'};
//        List<Integer> path1 = new ArrayList<>();
//        path1.add(1);
//        path1.add(8);
//        List<Integer> path2 = new ArrayList<>();
//        path2.add(2);
//        path2.add(8);
//        List<Integer> path3 = new ArrayList<>();
//        path3.add(1);
//        path3.add(1);
//        List<List<Integer>> invalidOperationRange = new ArrayList<>();
//        invalidOperationRange.add(path1);
//        invalidOperationRange.add(path2);
//        invalidOperationRange.add(path3);
//        System.out.println(countNumLists(operationLen, operations, invalidOperationRange));

//        int[] nums = new int[]{-2, 3, -4};
//        System.out.println(maxProduct(nums));

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(1);
//        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        root2.left = null;
        root2.right = new TreeNode(1);
        boolean flag = isSameTree(root1, root2);
        System.out.println(flag);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        TreeNode root1 = p, root2 = q;
        inorder(root1, sb1);
        inorder(root2, sb2);
        char[] chars1 = sb1.toString().toCharArray();
        char[] chars2 = sb2.toString().toCharArray();
        if (chars1.length != chars2.length) return false;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void inorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('#');
            return;
        }
        sb.append(root.val);
        inorder(root.left, sb);

        inorder(root.right, sb);
    }

    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, tmpMax = 1, tmpMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = tmpMax;
                tmpMax = tmpMin;
                tmpMin = tmp;
            }
            tmpMax = Math.max(tmpMax * nums[i], nums[i]);
            tmpMin = Math.min(tmpMin * nums[i], nums[i]);

            max = Math.max(max, tmpMax);
        }
        return max;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        int len = getLen(head);
        // 找到链表的倒数第k+1个节点
        k %= len;
        ListNode slow = getDivision(head, k);
        // 分裂链表
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode cur = newHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return newHead;
    }

    public static int getLen(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static ListNode getDivision(ListNode head, int k) {
        if (head == null) return head;
        ListNode slow = head, fast = head;
        List<ListNode> res = new LinkedList<>();
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        if (fast == null) return head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static List<Integer> countNumLists(int operationLen, char[] operations, List<List<Integer>> invalidOperationRange) {
        List<List<Integer>> resLists = new ArrayList<>();
        // 减去操作无效的操作区间
        for (List<Integer> integers : invalidOperationRange) {
            int invalidOperationLen = integers.get(1) - integers.get(0) + 1;
            char[] operationRange = new char[operationLen - invalidOperationLen];
            System.arraycopy(operations, operationLen - operationRange.length, operationRange, 0, operationRange.length);
            // 计算不重复元素个数
            int x = 0; // 初始元素为0
            List<Integer> path = new ArrayList<>();
            path.add(x); // 初始什么都不操作的情况下
            for (char c : operationRange) {
                if (c == '+') {
                    x += 1;
                } else {
                    x -= 1;
                }
                path.add(x);
            }
            resLists.add(path);
        }
        // 统计不同元素个数
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (List<Integer> resList : resLists) {
            set.addAll(resList);
            res.add(set.size());
            set.clear();
        }
        return res;
    }

}
