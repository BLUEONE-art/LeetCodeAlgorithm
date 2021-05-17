//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 6198 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        int c = 0; // 进位
        int lenL1 = len(l1);
        int lenL2 = len(l2);

        if (lenL1 < lenL2) { // l1短，改造成一样长
            ListNode dumL1 = l1;
            while (dumL1.next != null) dumL1 = dumL1.next;
            for (int i = 0; i < lenL2 - lenL1; i++) {
                dumL1.next = new ListNode(0);
                dumL1 = dumL1.next;
            }
            dumL1.next = null;
        }
        else {
            ListNode dumL2 = l2;
            while (dumL2.next != null) dumL2 = dumL2.next;
            for (int i = 0; i < lenL1 - lenL2; i++) {
                dumL2.next = new ListNode(0);
                dumL2 = dumL2.next;
            }
            dumL2.next = null;
        }

        while (l1 != null || l2 != null) {
            int sum = l1.val + l2.val + c;
            c = sum / 10;
            cur.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        if (c != 0) {
            cur.next = new ListNode(c);
            cur = cur.next;
        }
        cur.next = null;
        return dum.next;
    }

    public int len(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
