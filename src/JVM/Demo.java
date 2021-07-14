package JVM;


import org.junit.Test;

import java.text.DecimalFormat;
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

//        int[][] nums = new int[][]{{1, 2}, {3, 4}};
//        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] nums = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        // 堆排序测试
//        int[] arr = new int[]{1, 6, 8, 9, 34, 2, 44, 654};
//        heapSort(arr);
//        for (int i : arr) {
//            System.out.println(i);
//        }

        // 字符串重排列测试
        String test = "abbabbaaab";
        String res = reorganizeString(test);
        System.out.println(res);
    }

    public static String reorganizeString(String s) {
        // 找出出现次数最多的字母
        char[] chars = s.toCharArray();
        int len = s.length();
        int[] charsCount = new int[26];
        for (int i = 0; i < len; i++) {
            charsCount[chars[i] - 'a']++;
        }
        int max = 0;
        int maxNumCharIdx = 0;
        int threshold = (len + 1) >> 1;
        for (int i = 0; i < charsCount.length; i++) {
            if (charsCount[i] > max) {
                max = charsCount[i];
                maxNumCharIdx = i;
                if (max > threshold) {
                    return "";
                }
            }
        }
        // 构造结果
        char[] res = new char[len];
        int index = 0;
        for (int i = 0; i < max; i++) {
            res[index] = (char) (maxNumCharIdx + 'a');
            index += 2;
            charsCount[maxNumCharIdx]--;
        }
        // 再补充奇数位置的字母
        for (int i = 0; i < charsCount.length; i++) {
            while (charsCount[i] > 0) {
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
                charsCount[i]--;
            }
        }
        return new String(res);
    }

    //堆排序
    public static void heapSort(int[] arr) {
        //构造大根堆
        heapInsert(arr);
        int size = arr.length;
        while (size > 1) {
            //固定最大值
            swap(arr, 0, size - 1);
            size--;
            //构造大根堆
            heapify(arr, 0, size);

        }

    }

    //构造大根堆（通过新插入的数上升）
    public static void heapInsert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //当前插入的索引
            int currentIndex = i;
            //父结点索引
            int fatherIndex = (currentIndex - 1) / 2;
            //如果当前插入的值大于其父结点的值,则交换值，并且将索引指向父结点
            //然后继续和上面的父结点值比较，直到不大于父结点，则退出循环
            while (arr[currentIndex] > arr[fatherIndex]) {
                //交换当前结点与父结点的值
                swap(arr, currentIndex, fatherIndex);
                //将当前索引指向父索引
                currentIndex = fatherIndex;
                //重新计算当前索引的父索引
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }

    //将剩余的数构造成大根堆（通过顶端的数下降）
    public static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while (left < size) {
            int largestIndex;
            //判断孩子中较大的值的索引（要确保右孩子在size范围之内）
            if (arr[left] < arr[right] && right < size) {
                largestIndex = right;
            } else {
                largestIndex = left;
            }
            //比较父结点的值与孩子中较大的值，并确定最大值的索引
            if (arr[index] > arr[largestIndex]) {
                largestIndex = index;
            }
            //如果父结点索引是最大值的索引，那已经是大根堆了，则退出循环
            if (index == largestIndex) {
                break;
            }
            //父结点不是最大值，与孩子中较大的值交换
            swap(arr, largestIndex, index);
            //将索引指向孩子中较大的值的索引
            index = largestIndex;
            //重新计算交换之后的孩子的索引
            left = 2 * index + 1;
            right = 2 * index + 2;
        }

    }

    //交换数组中两个元素的值
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;
        int[] nums = new int[m * n];

        int k = 0;
        boolean bXFlag = true;
        for (int i = 0; i < m + n; i++) {
            int pm = bXFlag ? m : n;
            int pn = bXFlag ? n : m;

            int x = (i < pm) ? i : pm - 1;
            int y = i - x;

            while (x >= 0 && y < pn) {
                nums[k++] = bXFlag ? matrix[x][y] : matrix[y][x];
                x--;
                y++;
            }

            bXFlag = !bXFlag;
        }

        return nums;
    }

//    public static int[] findDiagonalOrder(int[][] mat) {
//        int n = mat.length, count = 0;
//        int[] res = new int[n * n];
//        LinkedList<Integer> resList = new LinkedList<>();
//        LinkedList<Integer> tmp = new LinkedList<>();
//        // 逆时针旋转九十度
//        antiClockwise90(mat);
//
//        for (int l = 0; l < n; l++) {
//            count++;
//            for (int i = 0; i < n - l; i++) {
//                int j = l + i;
//                if (i == j) {
//                    if (n % 2 == 0) {
//                        resList.addLast(mat[i][j]);
//                    } else {
//                        resList.addFirst(mat[i][j]);
//                    }
//                } else if (i == 0 && j == n - 1) { // 左下角和右上角
//                    resList.addLast(mat[i][j]);
//                    resList.addFirst(mat[j][i]);
//                } else { // 除去左下角、右上角和对角线的元素
//                    if (count % 2 != 0) {
//                        resList.addLast(mat[i][j]);
//                        tmp.addLast(mat[j][i]);
//                    } else {
//                        tmp.addLast(mat[i][j]);
//                        tmp.addFirst(mat[j][i]);
//                    }
//                }
//            }
//            while (!tmp.isEmpty()) {
//                if (count % 2 != 0) {
//                    resList.addFirst(tmp.removeLast());
//                } else {
//                    int size = tmp.size();
//                    int tempo = 0;
//                    resList.addFirst(tmp.removeFirst());
//                    resList.addLast(tmp.removeLast());
//                    tempo++;
//                    if (n % 2 == 0) {
//                        while (tempo < size / 2) {
//                            resList.add(tempo, tmp.removeFirst());
//                            resList.addLast(tmp.removeLast());
//                            tempo++;
//                        }
//                    } else {
//                        while (tempo < size / 2) {
//                            resList.addFirst(tmp.removeFirst());
//                            resList.add(resList.size() - 1 - tempo, tmp.removeLast());
//                            tempo++;
//                        }
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < resList.size(); i++) {
//            res[i] = resList.get(i);
//        }
//        return res;
//    }

    public static void antiClockwise90(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[n - 1 - i][j];
                mat[n - 1 - i][j] = tmp;
            }
        }
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        boolean sign = (numerator > 0) ^ (denominator > 0);
        StringBuilder res = new StringBuilder();
        if (sign) {
            res.append("-");
        }
        long numerator_long = numerator;
        long denominator_long = denominator;
        numerator_long = Math.abs(numerator_long);
        denominator_long = Math.abs(denominator_long);
        long integer = numerator_long / denominator_long;
        res.append(integer);

        String dot = ".";
        long remainder = numerator_long % denominator_long;
        if (remainder == 0) {
            return res.toString();
        } else {
            res.append(dot);
        }

        // 处理多位小数+循环小数
        Map<Long, Integer> map = new HashMap<>();
        int idx = res.length() - 1;
        while (remainder > 0) {
            idx++;
            remainder *= 10;
            if (map.get(remainder) != null) {
                res.insert(map.get(remainder), "(");
                res.append(")");
                break;
            } else {
                map.put(remainder, idx);
            }
            res.append(remainder / denominator_long);
            remainder = remainder % denominator_long;
        }
        return res.toString();
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
