package JVM;

import java.util.*;

public class teat {

    public static int canGet(int n, int k) {
        // 初始就有n包
        int count = n;
        int res = count;
        while ((count / k) != 0) {
            int newNoodle = count / k;
            res += newNoodle;
            count %= k;
            count += newNoodle;
        }
        return res;
    }

    public static int minCar() {
        return 1;
    }

//    public static int maxLen(int len, int[] nums) {
//        int[] dp = new int[len];
//        dp[0] = 0;
//        for (int i = 1; i < len; i++) {
//            if (nums[i - 1] != nums[i]) {
//                dp[i] = dp[i - 1] + 2;
//            } else {
//                dp[i] = dp[i - 1];
//            }
//        }
//        return dp[len - 1];
//    }

//    public static int maxLen(int len, int[] nums) {
//        int max = 0;
//        int tmp = nums[0];
//        for (int i = 1; i < len; i++) {
//            int leftIdx = 0;
//            tmp += nums[i];
//            if (tmp == 1 && nums[i - 1] != 1) {
//                tmp = 0;
//                max = i - leftIdx + 1;
//            }
//        }
//        return max;
//    }

//    public static int maxLen(int len, int[] nums) {
//        if (len == 0 || len == 1) return 0;
//        int max = 0;
//        int leftIdx = 0;
//        int flag = 1;
//        for (int i = 1; i < len; i++) {
//            if (nums[i - 1] != nums[i] || ) {
//                flag -= 1;
//            } else if (nums[i - 1] == nums[i]) {
//                flag += 1;
//            }
//            if (flag == 0) {
//                flag = 1;
//                max = Math.max(max, i - leftIdx + 1);
//                leftIdx = i;
//            }
//        }
//        return max;
//    }

    public static int maxLen(int len, int[] nums) {
        if (len == 0 || len == 1) return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(nums[0]);
        for (int i = 1; i < len; i++) {
            if (!stack.isEmpty() && stack.peek() != nums[i]) {
                stack.pop();
                continue;
            }
            stack.push(nums[i]);
        }
        return len - stack.size();
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sum = len1 + len2;
        int count = 0;
        int i = 0;
        int j = 0;
        double res = 0.0;
        int[] mergeNums = new int[sum];
        while (count <= sum && i < len1 && j < len2) {
            if (nums1[i] <= nums2[j]) {
                mergeNums[count] = nums1[i];
                i++;
            } else {
                mergeNums[count] = nums2[j];
                j++;
            }
            count++;
        }
        if (i == len1) {
            for (int k = j; k < len2; k++) {
                mergeNums[count] = nums2[k];
                count++;
            }
        } else {
            for (int l = i; l < len1; l++) {
                mergeNums[count] = nums1[l];
                count++;
            }
        }
        if (sum % 2 != 0) {
            res = (double) mergeNums[sum / 2];
        } else {
            res = (double) (mergeNums[sum / 2 - 1] + mergeNums[sum / 2]) / 2;
        }
        return res;
    }

    public static int[] haveCircularDependency(int n, int[][] prerequisites) {
        // 入度矩阵
        int[] inDegrees = new int[n];
        // 图的邻接矩阵
        List<List<Integer>> adjLists = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        // 一维变二维
        for (int i = 0; i < n; i++) {
            adjLists.add(new ArrayList<>());
        }
        // 计算邻接矩阵
        for (int i = 0; i < prerequisites.length; i++) {
            // 起始点
            int cur = prerequisites[i][0];
            // cur -指向-> next
            int next = prerequisites[i][1];
            // 被指向的点的入度+1
            inDegrees[next]++;
            // 邻接矩阵的表示方法：记录当前节点cur指向的节点
            adjLists.get(cur).add(next);
        }
        // 第一次取出入度矩阵中入度为0的节点的下标
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                q.offer(i);
            }
        }
        // BFS
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                ans.add(cur);
                List<Integer> adjList = adjLists.get(cur);
                for (int adj : adjList) {
                    // 因为指向adj的cur被取出，所有的被cur指向的节点的入度减1
                    inDegrees[adj]--;
                    if (inDegrees[adj] == 0) {
                        q.offer(adj);
                    }
                }
            }
        }
        int[] res;
        if (ans.size() == n) {
            res = ans.stream().mapToInt(Integer::valueOf).toArray();
        } else {
            res = new int[0];
        }
        return res;
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        for (int i : arr) {
            q.offer(i);
            if (q.size() > arr.length - k) {
                res.add(q.poll());
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newL1 = reverse(l1);
        ListNode newL2 = reverse(l2);
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        int c = 0;
        while (newL1 != null && newL2 != null) {
            int sum = newL1.val + newL2.val + c;
            c = sum / 10;
            int modSum = sum % 10;
            cur.next = new ListNode(modSum);
            cur = cur.next;
            newL1 = newL1.next;
            newL2 = newL2.next;
        }
        if (newL1 != null) {
            int sum = c + newL1.val;
            c = sum / 10;
            int modSum = sum % 10;
            cur.next = new ListNode(modSum);
            cur = cur.next;
            newL1 = newL1.next;
        } else {
            int sum = c + newL2.val;
            c = sum / 10;
            int modSum = sum % 10;
            cur.next = new ListNode(modSum);
            cur = cur.next;
            newL2 = newL2.next;
        }
        return reverse(dum.next);
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    static class TreeNode {
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

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, postorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public static TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int leftValIdx = -1;
        for (int i = 0; i < postorder.length; i++) {
            if (postorder[i] == preorder[preStart + 1]) {
                leftValIdx = i;
                break;
            }
        }
        int leftSize = leftValIdx - postStart + 1;
        root.left = build(preorder, preStart + 1, preStart + leftSize, postorder, postStart, leftValIdx);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, leftValIdx + 1, postEnd - 1);
        return root;
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        if (len == 0 || k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < len) {
            char c = s.charAt(right);
            map.put(c, right);
            right++;
            while (map.size() > k) {
                int min = Collections.min(map.values());
                map.remove(s.charAt(min));
                left = min + 1;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        // dp[i]前i个元素的最长子序列长度
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int count = 0;
        int max = 1;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        for (int i : dp) {
            if (i == max) {
                count++;
            }
        }
        return count;
    }

    public int longestSubstring(String s, int k) {
        int ans = 0;
        int len = s.length();
        char[] cs = s.toCharArray();
        int[] cnt = new int[26];
        for (int p = 1; p < 26; p++) {
            Arrays.fill(cnt, 0);
            for (int i = 0, j = 0, tot = 0, sum = 0; i < len; i++) {
                int u = cs[i] - 'a';
                cnt[u]++;
                if (cnt[u] == 1) {
                    tot++;
                }
                if (cnt[u] == k) {
                    sum++;
                }
                while (tot > p) {
                    int t = cs[j++] - 'a';
                    cnt[t]--;
                    if (cnt[t] == 0) {
                        tot--;
                    }
                    if (cnt[t] == k - 1) {
                        sum--;
                    }
                }
                if (tot == sum) {
                    ans = Math.max(ans, i - j + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 3, 5, 4, 7};
        int res = findNumberOfLIS(test);
        System.out.println(res);
        StringBuilder stringBuilder = new StringBuilder();

//        stringBuilder.
        List<String> res1 = new ArrayList<>();
    }
}
