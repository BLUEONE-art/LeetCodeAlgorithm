//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 817 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        preTraverse(head, sb1);
        postTraverse(head, sb2);

        // 判断
        for (int i = 0; i < sb1.length(); i++) {
            if (sb1.charAt(i) != sb2.charAt(i)) return false;
        }
        return true;
    }

    // 前序遍历链表
    public static void preTraverse(ListNode head, StringBuilder sb) {
        if (head == null) return;

        // 前序遍历代码
        sb.append(head.val);

        preTraverse(head.next, sb);
    }

    // 后序遍历链表
    public static void postTraverse(ListNode head, StringBuilder sb) {
        if (head == null) return;

        postTraverse(head.next, sb);

        // 后序遍历代码
        sb.append(head.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
